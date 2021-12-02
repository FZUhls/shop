package com.henry.shop.commodity.dto.res;

import lombok.Data;

/**
 * @author Henry
 */
@Data
public class CommodityShortRes {
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 类别id
     */
    private Long categoryId;

    /**
     * 图片url
     */
    private String imageUrl;
}
