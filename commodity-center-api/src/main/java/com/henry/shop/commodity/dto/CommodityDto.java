package com.henry.shop.commodity.dto;

import lombok.Data;

/**
 * 商品添加表单
 * @author Henry
 */
@Data
public class CommodityDto {
    /**
     * 参数组名
     */
    private String name;
    /**
     * 目录
     */
    private Long categoryId;
    /**
     * 规格组id
     */
    private Long variantGropuId;

}
