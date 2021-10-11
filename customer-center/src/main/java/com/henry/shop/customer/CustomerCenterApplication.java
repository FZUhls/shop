package com.henry.shop.customer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo(scanBasePackages = "com.henry.shop.customer.service")
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
public class CustomerCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerCenterApplication.class, args);
    }

}
