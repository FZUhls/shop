package com.henry.shop.commodity.test.service;

import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.ParamItemDto;
import com.henry.shop.commodity.dto.req.SkuDto;
import com.henry.shop.commodity.service.ParamService;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommodityServiceTest extends BaseTest{
    @Autowired
    ParamService paramService;
    @Test
    void testCreate(){

    }
    private CommodityDto getCommodityDto(){
        CommodityDto commodityDto = new CommodityDto();
        commodityDto.setBrandId(1L);
        commodityDto.setCategoryId(1L);
        commodityDto.setName("普通t");
        commodityDto.setVariantGroupId(1L);
        ParamItemDto param1 = new ParamItemDto();
        param1.setParamId(14L);
        param1.setValue("尼龙");
        ParamItemDto param2 = new ParamItemDto();
        param2.setParamId(15L);
        param2.setValue("短袖");
        commodityDto.setParamItemDtoList(List.of(param1,param2));
        List<SkuDto> list = new ArrayList<>();
        SkuDto skuDto = new SkuDto();
        //todo 完成商品dto
        return commodityDto;
    }
    private List<ParamItemDto> randomParam(long paramGroupId){
        List<ComParam> params = paramService.getParams(paramGroupId);
        List<ParamItemDto> paramItemDtoList = new ArrayList<>();
        for(ComParam param : params){
            ParamItemDto itemDto = new ParamItemDto();
            itemDto.setParamId(param.getId());
            String[] values;
            switch (param.getType()){
                case SINGLE_SELECT:
                    values = param.getSelectValue().split(",");
                    itemDto.setValue(values[0]);
                    break;
                case MULTI_SELECT:
                    values = param.getSelectValue().split(",");
                    itemDto.setValue(values[0]+","+values[1]);
                    break;
                case INPUT:
                    itemDto.setValue("XXXX");
                    break;
            }
            paramItemDtoList.add(itemDto);
        }
        return paramItemDtoList;
    }

}
