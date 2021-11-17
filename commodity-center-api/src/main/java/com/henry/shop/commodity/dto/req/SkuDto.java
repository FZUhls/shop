package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

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

    /**
     * 规格1的id
     */
    @ApiModelProperty("规格1的id")
    private Long variantId1;

    /**
     * 规格2的id
     */
    @ApiModelProperty("规格2的id")
    private Long variantId2;

    /**
     * 规格3的id
     */
    @ApiModelProperty("规格3的id")
    private Long variantId3;

    /**
     * 规格1的值
     */
    @ApiModelProperty("规格1的id")
    private String  variantItem1;

    /**
     * 规格2的值
     */
    @ApiModelProperty("规格2的id")
    private String  variantItem2;

    /**
     * 规格3的值
     */
    @ApiModelProperty("规格3的id")
    private String variantItem3;
}
