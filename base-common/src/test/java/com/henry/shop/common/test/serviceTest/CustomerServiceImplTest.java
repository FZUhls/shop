package com.henry.shop.common.test.serviceTest;

import com.alibaba.fastjson.JSON;
import com.henry.shop.common.base.enumerate.CustomerStatus;
import com.henry.shop.common.base.enumerate.Sex;
import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.common.base.model.dataobj.usr.Customer;
import com.henry.shop.common.manager.CustomerManager;
import com.henry.shop.common.test.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Slf4j
class CustomerServiceImplTest extends BaseTest {
    @Autowired
    CustomerManager customerManager;
    @Autowired
    CustomerMapper customerMapper;
    @Test
    void saveTest(){
        Customer customer = new Customer();
        customer.setAge(21);
        customer.setIconUrl("21212");
        customer.setNickName("hahah");
        customer.setPhone("15559191726");
        customer.setRealName("施亨利");
        customer.setSex(Sex.MALE);
        customer.setStatus(CustomerStatus.VALID);
        customer.setPasswd("2131321");
        customer.setCreTime(new Date());
        customer.setUpdTime(new Date());
        customerManager.insert(customer);
    }
    @Test
    void test2(){
        Customer customer = customerMapper.selectById(3L);
        log.info(JSON.toJSONString(customer));
    }

}