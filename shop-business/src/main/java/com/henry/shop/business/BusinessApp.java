package com.henry.shop.business;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Henry
 * 商家端启动类
 */
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
@EnableDubbo(scanBasePackages = "com.henry.shop.business")
public class BusinessApp {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
