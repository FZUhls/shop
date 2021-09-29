package com.henry.shop.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Henry
 * 商家端启动类
 */
@EnableDubboConfig
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
public class BusinessApp {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
