package com.henry.shop.business;

import ch.qos.logback.core.spi.LogbackLock;
import com.henry.shop.common.base.mapper.bil.BillListMapper;
import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.model.bil.BillList;
import com.henry.shop.common.base.model.location.Province;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BusinessAppTests {

    @Resource
    ProvinceMapper provinceMapper;
    @Resource
    BillListMapper billListMapper;
    Logger LOG = LoggerFactory.getLogger(BusinessAppTests.class);
    @Test
    void testProvinceMapper() {
        long start = System.currentTimeMillis();
        Province province = provinceMapper.selectById(2);
        long time = System.currentTimeMillis() - start;
        System.out.println(time);
        System.out.println(province);
    }
    @Test
    void testBillMapper(){
        BillList billList = new BillList();
        billList.setCustomerId(312L);
        billListMapper.insert(billList);
    }
    @Test
    void testLog(){
        LOG.info("222");
    }

}
