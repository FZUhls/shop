package com.henry.shop.commodity.controller;

import com.henry.shop.commodity.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Henry
 */
@RestController
@Slf4j
public class CommodityController {

    private static final String BASE = "/commodity";
    private static final String CREATE = BASE + "/create";
    private static final String UPDATE = BASE + "/update/{id}";
    private static final String DELETE = BASE + "/delete/{id}";
    private static final String SELETE = BASE + "/select/{id}";

    @Autowired
    private CommodityService commodityService;

    @GetMapping(SELETE)
    public static final String selectOne(@PathVariable("id") long id){
        commodityService
    }
}
