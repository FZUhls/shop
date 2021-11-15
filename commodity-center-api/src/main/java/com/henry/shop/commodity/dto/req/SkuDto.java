package com.henry.shop.commodity.dto.req;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * sku dto
 * @see com.henry.shop.common.base.model.dataobj.com.ComSKU
 * @author Henry
 */
@Data
@ToString
public class SkuDto {

    /**
     * sku code 具有唯一性
     */
    private String skuCode;

    /**
     * 价格
     */
    private String price;

    /**
     * 数量
     */
    private Integer skuNumber;
}
