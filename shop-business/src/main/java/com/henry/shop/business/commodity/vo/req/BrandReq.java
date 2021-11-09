package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("品牌表单")
public class BrandReq implements Serializable {
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
