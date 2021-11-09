package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌的dto类
 * @see com.henry.shop.common.base.model.dataobj.com.Brand
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
