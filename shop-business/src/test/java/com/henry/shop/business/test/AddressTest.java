package com.henry.shop.business.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
public class AddressTest extends BaseTest{
    @Resource
    ProvinceMapper provinceMapper;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void test1() throws JsonProcessingException {
        List<Province> all = provinceMapper.findAll();
        log.info(objectMapper.writeValueAsString(all));
    }
}
