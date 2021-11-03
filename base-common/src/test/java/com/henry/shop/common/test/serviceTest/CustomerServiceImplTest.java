package com.henry.shop.common.test.serviceTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.common.base.enumerate.CustomerStatus;
import com.henry.shop.common.base.enumerate.Sex;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.mapper.com.BrandMapper;
import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import com.henry.shop.common.base.model.dataobj.usr.Customer;
import com.henry.shop.common.manager.CustomerManager;
import com.henry.shop.common.test.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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
    @Test
    void test3(){
        String str = "{\"age\":21,\"creTime\":1634825088000,\"iconUrl\":\"21212\",\"id\":\"3\",\"nickName\":\"hahah\",\"passwd\":\"2131321\",\"phone\":\"15559191726\",\"realName\":\"施亨利\",\"sex\":1,\"status\":1,\"updTime\":1634825088000}";
        Customer customer = JSON.parseObject(str,Customer.class);
        System.out.println(JSON.toJSONString(customer));
    }
    class Person{
        String name;
        List<String> nickName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getNickName() {
            return nickName;
        }

        public void setNickName(List<String> nickName) {
            this.nickName = nickName;
        }
    }
    @Autowired
    BrandMapper brandMapper;
    @Test
    void test4(){
        Page<Brand> brandIpage = new Page<>();
        brandIpage.setCurrent(0);
        brandIpage.setSize(3);
        IPage<Brand> page = brandMapper.getByPageAndName(brandIpage, null);
        BaseResponse<IPage<Brand>> response = BaseResponse.succ();
        response.setData(page);
        String str = JSON.toJSONString(response);
        log.info(str + "\n");

        BaseResponse<IPage<Brand>> response2 = JSON.parseObject(str,BaseResponse.class);
        log.info(JSON.toJSONString(response2));
    }

}