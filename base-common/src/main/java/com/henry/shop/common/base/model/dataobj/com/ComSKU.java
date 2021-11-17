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

    /**
     * 数量
     */
    @ApiModelProperty("sku 数量")
    private Integer skuNumber;
}
