package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品sku表
 * @author henry1
 */
@Data
@ToString
@TableName("com_sku")
@ApiModel("商品sku")
public class ComSKU implements Serializable {
    @ApiModelProperty("sku id")
    private Long id;
    /**
     * sku code 具有唯一性
     */
    @ApiModelProperty("sku code")
    private String skuCode;
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long commodityId;
    /**
     * 价格
     */
    @ApiModelProperty("sku价格")
    private BigDecimal price;
    /**
     * 规格1
     */
    @ApiModelProperty("规格1")
    private Long variantId1;

    /**
     * 规格2
     */
    @ApiModelProperty("规格2")
    private Long variantId2;

    /**
     * 规格3
     */
    @ApiModelProperty("规格3")
    private Long variantId3;

    /**
     * 数量
     */
    @ApiModelProperty("sku 数量")
    private Integer skuNumber;
}
