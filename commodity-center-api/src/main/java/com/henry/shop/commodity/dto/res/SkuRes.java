package com.henry.shop.commodity.dto.res;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Henry
 */
@Data
public class SkuRes {
    @ApiModelProperty("sku id")
    private Long id;

    /**
     * sku code 具有唯一性
     */
    @ApiModelProperty("sku code")
    private String skuCode;

    /**
     * 价格
     */
    @ApiModelProperty("sku价格")
    private BigDecimal price;

    /**
     * 规格列表
     */
    private Map<Long,String> variantMap;
}
