package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Henry
 */
@ApiModel
@Data
public class VariantGroupVo {
    /**
     * 规格组名
     */
    @ApiModelProperty("规格组名")
    private String name;
}
