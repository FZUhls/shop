package com.henry.shop.common.test.serviceTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.henry.shop.common.base.mapper.com.ComSKUMapper;
import com.henry.shop.common.base.model.dataobj.com.ComSKU;
import com.henry.shop.common.test.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
@Slf4j
public class ComSkuMapperTest extends BaseTest {
    @Autowired
    ComSKUMapper comSKUMapper;
    @Test
    void test(){
        List<ComSKU> skus1 = comSKUMapper.selectByMap(Map.of("commodity_id", 1L));
        List<ComSKU> skus2 = comSKUMapper.selectByMap(Map.of("commodity_id", 2L));
        QueryWrapper<ComSKU> wrapper = new QueryWrapper<>();
        log.info(JSON.toJSONString(skus1));
        log.info(JSON.toJSONString(skus2));
    }
}
