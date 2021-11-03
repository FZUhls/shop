package com.henry.shop.common.test.serviceTest;

import com.alibaba.fastjson.JSON;
import com.henry.shop.common.base.enumerate.ParamType;
import com.henry.shop.common.base.mapper.com.ComParamMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.test.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ParamServiceTest extends BaseTest {
    @Autowired
    ComParamMapper comParamMapper;
    @Test
    void test(){
        ComParam comParam = new ComParam();
        comParam.setParamGroupId(1L);
        comParam.setSort(1);
        comParam.setSelectValue("尼龙,羊毛,亚麻");
        comParam.setType(ParamType.getByCode(0));
        comParam.setCreTime(new Date());
        comParam.setUpdTime(new Date());
        comParam.setName("材料");
        comParamMapper.insert(comParam);
    }
    @Test
    void test1(){
        ComParam comParam = comParamMapper.selectById(3L);
        System.out.println(JSON.toJSONString(comParam));
    }
}
