package com.henry.shop.commodity.test.service;

import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.ParamItemDto;
import com.henry.shop.commodity.dto.req.SkuDto;
import com.henry.shop.commodity.service.CommodityService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.ParamIllegalException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StringTest extends BaseTest{
    @Autowired
    CommodityService commodityService;
    @Test
    void test1(){
        CommodityDto commodityDto = new CommodityDto();
        commodityDto.setBrandId(1L);
        commodityDto.setName("衬衫");
        commodityDto.setSkuDtoList(List.of(new SkuDto()));
        commodityDto.setParamItemDtoList(List.of(new ParamItemDto()));
        commodityDto.setVariantGroupId(1L);
        commodityDto.setCategoryId(1L);
        try {
            commodityService.createCommodity(commodityDto);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        } catch (ParamIllegalException e) {
            e.printStackTrace();
        }
    }
}
