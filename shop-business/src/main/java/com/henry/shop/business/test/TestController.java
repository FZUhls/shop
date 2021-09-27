package com.henry.shop.business.test;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Henry
 */
@Api(tags = "TestController")
@RestController
public class TestController {
    @GetMapping("test1")
    public String test1(){
        return "hello world";
    }
}
