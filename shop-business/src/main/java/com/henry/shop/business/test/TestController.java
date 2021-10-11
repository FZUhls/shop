package com.henry.shop.business.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.customer.api.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author Henry
 */
@Api(tags = "TestController")
@RestController
public class TestController {
    @DubboReference
    CustomerService customerService;
    @Autowired
    ObjectMapper objectMapper;
    @SneakyThrows
    @GetMapping("test1/{id}")
    @ApiOperation(value = "测试接口",notes = "测试接口，返回一个省份信息")
    public Province test1(@PathVariable Long id){
        Province province = customerService.getProvinceById(id);
        return province;
    }
}
