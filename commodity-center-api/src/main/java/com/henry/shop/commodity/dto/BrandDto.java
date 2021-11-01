package com.henry.shop.commodity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("品牌dto")
public class BrandDto implements Serializable {
    /**
     * 品牌code，唯一性
     */
    @ApiModelProperty("品牌code")
    private String brandCode;
    /**
     * 品牌名
     */
    @ApiModelProperty("品牌名")
    private String brandName;
}
