package com.henry.shop.commodity.dto.req;

import lombok.Data;

/**
 * @author Henry
 */
@Data
public class SkuUpdItem {

    private Long id;
    /**
     * 价格
     */
    private String price;

    /**
     * 数量
     */
    private Integer skuNumber;
}
