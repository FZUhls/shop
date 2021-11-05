package com.henry.shop.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Henry
 * 商家端启动类
 */
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.henry.shop.commodity.api"})
@EnableAspectJAutoProxy
public class BusinessApp {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
