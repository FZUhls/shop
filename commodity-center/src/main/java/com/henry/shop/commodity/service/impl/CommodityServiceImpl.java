package com.henry.shop.commodity.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.*;
import com.henry.shop.commodity.dto.res.CommodityRes;
import com.henry.shop.commodity.dto.res.CommodityShortRes;
import com.henry.shop.commodity.dto.res.SkuRes;
import com.henry.shop.commodity.service.*;
import com.henry.shop.common.base.enumerate.ParamType;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.exception.ParamIllegalException;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.mapper.com.ComParamItemMapper;
import com.henry.shop.common.base.mapper.com.ComSKUMapper;
import com.henry.shop.common.base.mapper.com.CommodityMapper;
import com.henry.shop.common.base.model.dataobj.com.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Henry
 */
@Service
@Slf4j
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    ComSKUMapper comSKUMapper;
    @Autowired
    VariantService variantService;
    @Autowired
    ComParamItemMapper comParamItemMapper;
    @Autowired
    ParamService paramService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @Override
    public Commodity createCommodity(CommodityDto commodityDto) throws DataNotFoundException, ParamIllegalException {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityDto,commodity);
        commodity.setImageUrl("");
        commodity.setPublishStatus(PublishStatus.WAIT_SALE);
        commodity.setCreTime(new Date());
        commodity.setUpdTime(new Date());
        List<SkuDto> skuDtoList = commodityDto.getSkuDtoList();
        commodityMapper.insert(commodity);
        //处理商品属性
        createParams(commodityDto.getParamItemDtoList(),commodity.getId(),commodityDto.getCategoryId());
        //创建sku
        Long commodityId = commodity.getId();
        createSku(skuDtoList,commodityId);
        return commodity;
    }

    @Override
    public Commodity updateCommodity(long id, CommodityUpdDto commodityUpdDto) throws DataNotFoundException {
        Commodity commodityOld = commodityMapper.selectById(id);
        if(Objects.isNull(commodityOld)){
            throw new DataNotFoundException();
        }
        commodityOld.setName(commodityUpdDto.getName());
        String url = String.join(",",commodityUpdDto.getImageUrls());
        commodityOld.setImageUrl(url);
        commodityOld.setUpdTime(new Date());
        commodityMapper.updateById(commodityOld);
        if(commodityUpdDto.isNewVariant()){
            log.info("更新商品时添加的新的规格，开始存入新的sku");
            createSku(commodityUpdDto.getNewSkuDtoList(),id);
        }
        return commodityOld;
    }

    @Override
    public void updateSku(SkuUpdDto skuUpdDto) {
        Long commodityId = skuUpdDto.getCommodityId();
        List<SkuUpdItem> updItems = skuUpdDto.getUpdItems();
        Map<Long, SkuUpdItem> skuUpdItemMap = updItems.stream().collect(Collectors.toMap(SkuUpdItem::getId, Function.identity()));
        List<ComSKU> comSKUList = comSKUMapper.selectByMap(Map.of("commodity_id",commodityId));
        comSKUList.forEach(sku->{
            SkuUpdItem updItem = skuUpdItemMap.get(sku.getId());
            sku.setPrice(new BigDecimal(updItem.getPrice()));
            sku.setSkuNumber(updItem.getSkuNumber());
            comSKUMapper.updateById(sku);
        });
    }

    @Override
    public void deleteCommodity(long id) throws DataNotFoundException {
        Commodity commodity = commodityMapper.selectById(id);
        if(Objects.isNull(commodity)){
            throw new DataNotFoundException();
        }
        commodityMapper.deleteById(id);
        List<ComSKU> skus = comSKUMapper.selectByMap(Map.of("commodity_id", id));
        comSKUMapper.deleteBatchIds(skus.stream().map(ComSKU::getId).collect(Collectors.toList()));
    }

    @Override
    public CommodityRes selectById(long id) throws DataNotFoundException {
        Commodity commodity = commodityMapper.selectById(id);
        if(Objects.isNull(commodity)){
            throw new DataNotFoundException();
        }
        Map<String, Map<String, String>> paramGroupMap = getParamGroupMap(commodity.getId(), commodity.getCategoryId());
        CommodityRes commodityRes = new CommodityRes();
        BeanUtils.copyProperties(commodity,commodityRes);
        commodityRes.setParamMap(paramGroupMap);
        Brand brand = brandService.findById(commodity.getBrandId());
        commodityRes.setBrandName(brand.getBrandName());
        Long variantGroupId = commodity.getVariantGroupId();
        List<ComVariant> variants = variantService.getVariantByGroupId(variantGroupId);
        Map<Long, String> variantId2NameMap = variants.stream().collect(Collectors.toMap(v -> v.getId(), v -> v.getName()));
        commodityRes.setVariantId2NameMap(variantId2NameMap);
        commodityRes.setSkuRes(getSkuResList(id));
        return commodityRes;
    }


    @Override
    public Page<CommodityShortRes> getCommoditys(long pageNo, long size, String keyWord) {
        Page<CommodityShortRes> commodityShortResPage = findCommoditys(pageNo, size, keyWord);
        return commodityShortResPage;
    }

    @Override
    public Commodity updateCommodityPublishStatus(long id, PublishStatus publishStatus) throws DataNotFoundException {
        Commodity commodity = commodityMapper.selectById(id);
        if(Objects.isNull(commodity)){
            throw new DataNotFoundException();
        }
        commodity.setPublishStatus(publishStatus);
        commodityMapper.updateById(commodity);
        return commodity;
    }

    /**
     * 处理商品属性
     * @param paramItemDtoList 属性列表
     * @param commodityId 商品id
     * @param categoryId 商品列表id
     */
    private void createParams(List<ParamItemDto> paramItemDtoList, long commodityId, long categoryId) throws ParamIllegalException, DataNotFoundException {
        checkParamsValid(paramItemDtoList, categoryId);
        for(ParamItemDto itemDto : paramItemDtoList){
            ComParamItem comParamItem = new ComParamItem();
            comParamItem.setParamId(itemDto.getParamId());
            comParamItem.setParamValue(itemDto.getValue());
            comParamItem.setCommodityId(commodityId);
            comParamItem.setCreTime(new Date());
            comParamItem.setUpdTime(new Date());
            comParamItemMapper.insert(comParamItem);
        }
    }

    /**
     * @param paramItemDtoList 属性列表
     * @param categoryId 商品类型id
     * @throws ParamIllegalException 当某个属性值不符合该属性的类型时抛出
     */
    private void checkParamsValid(List<ParamItemDto> paramItemDtoList, long categoryId) throws ParamIllegalException, DataNotFoundException {
        List<CategoryParamGroupRelation> relations = categoryService.selectRelationByCategoryId(categoryId);
        Set<Long> paramIdSet = new HashSet<>(relations.size() * 3);
        for(CategoryParamGroupRelation relation : relations){
            Long paramGroupId = relation.getParamGroupId();
            List<ComParam> params = paramService.getParams(paramGroupId);
            paramIdSet.addAll(params.stream().map(ComParam::getId).collect(Collectors.toList()));
        }
        for(ParamItemDto paramItemDto : paramItemDtoList){
            if(!paramIdSet.contains(paramItemDto.getParamId())){
                throw new ParamIllegalException("参数不存在");
            }
            ComParam comParam = paramService.selectParamById(paramItemDto.getParamId());
            if(Objects.equals(ParamType.MULTI_SELECT,comParam.getType()) || Objects.equals(ParamType.SINGLE_SELECT,comParam.getType())){
                paramService.checkParamLegal(comParam,paramItemDto.getValue());
            }
        }
    }

    /**
     * 处理添加商品sku
     * @param skuDtoList sku列表
     */
    private void createSku(List<SkuDto> skuDtoList,long commodityId){
        for(SkuDto skuDto : skuDtoList){
            ComSKU sku = new ComSKU();

            BeanUtils.copyProperties(skuDto,sku);
            sku.setPrice(new BigDecimal(skuDto.getPrice()));
            sku.setCommodityId(commodityId);
            comSKUMapper.insert(sku);
        }
    }

    /**
     * 获取商品参数
     * @param commodityId 商品id
     * @param categoryId 分类id
     * @return <pre class="code">{
     * "属性组名1":{"属性名1":"XXX","属性名2":"BBB"},
        "属性组名2":{"属性名1":"XXX","属性名2":"SSS"}
    }</pre>
     * @throws DataNotFoundException 数据不完整时抛出异常
     */
    private Map<String,Map<String,String>> getParamGroupMap(long commodityId, long categoryId) throws DataNotFoundException {
        List<CategoryParamGroupRelation> categoryParamGroupRelations = categoryService.selectRelationByCategoryId(categoryId);
        Map<String,Map<String ,String>> paramGroupMap = new HashMap<>();
        List<ComParamItem> paramItems = comParamItemMapper.selectByCommodityId(commodityId);
        Map<Long,String> itemMap = new HashMap<>();
        for(ComParamItem item : paramItems){
            itemMap.put(item.getParamId(),item.getParamValue());
        }
        for(CategoryParamGroupRelation relation : categoryParamGroupRelations){
            Long paramGroupId = relation.getParamGroupId();
            String groupName;
            String alias = relation.getAlias();
            if(alias.isBlank()){
                ComParamGroup comParamGroup = paramService.selectParamGroupById(paramGroupId);
                groupName = comParamGroup.getName();
            }else {
                groupName = alias;
            }
            List<ComParam> params = paramService.getParams(paramGroupId);
            Map<String, String> paramMap = params.stream().collect(Collectors.toMap(param -> param.getName(), param -> itemMap.get(param.getId())));
            paramGroupMap.put(groupName,paramMap);
        }
        return paramGroupMap;
    }

    /**
     * @param commodityId 商品id
     * @return 商品sku列表
     */
    private List<SkuRes> getSkuResList(long commodityId){
        List<ComSKU> comSKUS = comSKUMapper.selectByMap(Map.of("commodity_id", commodityId));
        return comSKUS.stream().map(sku -> {
            SkuRes skuRes = new SkuRes();
            BeanUtils.copyProperties(sku, skuRes);
            Map<Long, String> variantId2ValueMap = new HashMap<>();
            variantId2ValueMap.put(sku.getVariantId1(), sku.getVariantItem1());
            variantId2ValueMap.put(sku.getVariantId2(), sku.getVariantItem2());
            variantId2ValueMap.put(sku.getVariantId3(), sku.getVariantItem3());
            skuRes.setVariantMap(variantId2ValueMap);
            return skuRes;
        }).collect(Collectors.toList());
    }
    private Page<CommodityShortRes> findCommoditys(long pageNo,long size,String keyword){
        Page<Commodity> page = new Page<>();
        page.setPages(pageNo);
        page.setSize(size);
        Page<Commodity> commodityPage = commodityMapper.getByPage(page, keyword);
        List<Commodity> records = commodityPage.getRecords();
        List<CommodityShortRes> commodityShortResList = records.stream().map(record -> {
            CommodityShortRes commodityShortRes = new CommodityShortRes();
            commodityShortRes.setId(record.getId());
            commodityShortRes.setName(record.getName());
            commodityShortRes.setImageUrl(record.getImageUrl());
            commodityShortRes.setCategoryId(record.getCategoryId());
            return commodityShortRes;
        }).collect(Collectors.toList());
        Page<CommodityShortRes> pageRes = new Page<>();
        BeanUtils.copyProperties(page,pageRes);
        pageRes.setRecords(commodityShortResList);
        return pageRes;
    }
}
