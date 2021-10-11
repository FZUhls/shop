package com.henry.shop.common.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.common.test.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
class ShopCommonApplicationTests extends BaseTest {
    @Resource
    ProvinceMapper provinceMapper;
    @Resource
    ObjectMapper objectMapper;
    @Test
    void test1() throws JsonProcessingException {
        List<Province> all = provinceMapper.findAll();
        log.info(objectMapper.writeValueAsString(all));
    }
}
