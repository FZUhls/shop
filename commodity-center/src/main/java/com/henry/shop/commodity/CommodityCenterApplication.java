package com.henry.shop.commodity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Henry
 */
@SpringBootApplication(scanBasePackages = {"com.henry.shop"})
@EnableDiscoveryClient
@EnableAspectJAutoProxy
public class CommodityCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommodityCenterApplication.class, args);
    }
}
