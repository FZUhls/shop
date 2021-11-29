package com.henry.shop.commodity.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.ParamItemDto;
import com.henry.shop.commodity.dto.req.SkuDto;
import com.henry.shop.commodity.service.CategoryService;
import com.henry.shop.commodity.service.CommodityService;
import com.henry.shop.commodity.service.ParamService;
import com.henry.shop.commodity.service.VariantService;
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
    public Commodity updateCommodity(long id, CommodityDto commodityDto) throws DataNotFoundException {
        Commodity commodityOld = commodityMapper.selectById(id);
        if(Objects.isNull(commodityOld)){
            throw new DataNotFoundException();
        }
        commodityOld.setUpdTime(new Date());
        commodityOld.setName(commodityDto.getName());
        commodityOld.setBrandId(commodityDto.getBrandId());
        commodityOld.setVariantGroupId(commodityDto.getVariantGropuId());
        commodityOld.setImageUrl("");
        return null;
    }

    @Override
    public void deleteCommodity(long id) {

    }

    @Override
    public Page<Commodity> getCommoditys(long pageNo, long size, String keyWord) {
        return null;
    }

    @Override
    public Commodity updateCommodityPublishStatus(long id, PublishStatus publishStatus) {
        return null;
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
        Set<ComParam> paramSet = new HashSet<>(relations.size() * 3);
        for(CategoryParamGroupRelation relation : relations){
            Long paramGroupId = relation.getParamGroupId();
            List<ComParam> params = paramService.getParams(paramGroupId);
            paramSet.addAll(params);
        }
        for(ParamItemDto paramItemDto : paramItemDtoList){
            if(!paramSet.contains(paramItemDto)){
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
            comSKUMapper.insert(sku);
        }
    }
}
