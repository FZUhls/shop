package com.henry.shop.commodity.dto;

import com.henry.shop.common.base.enumerate.PublishStatus;
import lombok.Data;

@Data
public class ComodityDto {
    private String name;
    /**
     * 类别id
     */
    private Long categoryId;
    /**
     * 规格组id
     */
    private Long variantGroupId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 上架状态
     */
    private PublishStatus publishStatus;
}
