package com.henry.shop.commodity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
public class BrandDto implements Serializable {
    /**
     * 品牌code，唯一性
     */
    private String brandCode;
    /**
     * 品牌名
     */
    private String brandName;
}
