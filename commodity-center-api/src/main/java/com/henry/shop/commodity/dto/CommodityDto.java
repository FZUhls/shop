package com.henry.shop.commodity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品添加表单
 * @author Henry
 */
@Data
public class CommodityDto implements Serializable {
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
