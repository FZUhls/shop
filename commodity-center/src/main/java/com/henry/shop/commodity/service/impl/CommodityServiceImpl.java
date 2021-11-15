package com.henry.shop.commodity.service.impl;

import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.SkuDto;
import com.henry.shop.commodity.service.CommodityService;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.mapper.com.ComSKUMapper;
import com.henry.shop.common.base.mapper.com.CommodityMapper;
import com.henry.shop.common.base.model.dataobj.com.ComSKU;
import com.henry.shop.common.base.model.dataobj.com.ComVariantItem;
import com.henry.shop.common.base.model.dataobj.com.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    ComVariantItem comVariantItem;
    @Override
    public Commodity createCommodity(CommodityDto commodityDto) {
        Commodity commodity = new Commodity();
        commodity.setName(commodityDto.getName());
        commodity.setBrandId(commodityDto.getBrandId());
        commodity.setCategoryId(commodityDto.getCategoryId());
        commodity.setImageUrl("");
        commodity.setPublishStatus(PublishStatus.WAIT_SALE);
        commodity.setVariantGroupId(commodityDto.getVariantGropuId());
        commodity.setCreTime(new Date());
        commodity.setUpdTime(new Date());
        List<SkuDto> skuDtoList = commodityDto.getSkuDtoList();
        commodityMapper.insert(commodity);
        //创建sky
        Long commodityId = commodity.getId();
        Long variantGroupId = commodity.getVariantGroupId();
        createSku(skuDtoList,commodityId,variantGroupId);
        return commodity;
    }

    @Override
    public Commodity updateCommodity(long id, CommodityDto commodityDto) {
        return null;
    }

    @Override
    public void deleteCommodity(long id) {

    }

    @Override
    public Commodity getCommoditys(long pageNo, long size, String keyWord) {
        return null;
    }

    @Override
    public Commodity updateCommodityPublishStatus(long id, PublishStatus publishStatus) {
        return null;
    }

    /**
     * 处理添加商品sku
     * @param skuDtoList sku列表
     */
    private void createSku(List<SkuDto> skuDtoList,long commodityId,long variantGroupId){
        for(SkuDto skuDto : skuDtoList){
            ComSKU sku = new ComSKU();
            sku.setSkuCode(skuDto.getSkuCode());
            sku.setPrice(new BigDecimal(skuDto.getPrice()));
            sku.setSkuNumber(skuDto.getSkuNumber());
            sku.setVariantId1();
            sku.setVariantId2();
        }
    }
}
