package com.henry.shop.commodity;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
@EnableDubbo(scanBasePackages = "com.henry.shop.commodity")
public class CommodityCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommodityCenterApplication.class, args);
    }

}
