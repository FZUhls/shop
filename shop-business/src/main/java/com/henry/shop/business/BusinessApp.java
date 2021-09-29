package com.henry.shop.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Henry
 * 商家端启动类
 */
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
public class BusinessApp {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
