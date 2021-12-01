package com.henry.shop.commodity.dto.res;

import com.henry.shop.common.base.enumerate.PublishStatus;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Henry
 */
@Data
public class CommodityRes {

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
     * 规格名
     */
    private String categoryName;

    /**
     * 参数组id对应表
     */
    private Map<String,Map<String,String>> paramMap;

    /**
     * 规格id对应map
     */
    private Map<Long,String> variantId2NameMap;
    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 上架状态
     */
    private PublishStatus publishStatus;

    /**
     * sku列表
     */
    private List<SkuRes> skuRes;
}
