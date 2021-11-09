package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@ApiModel("参数组dto")
@Data
public class ParamGroupDto implements Serializable {
    /**
     * id
     */
    @ApiModelProperty("参数组id")
    private Long id;
    /**
     * 参数组名
     */
    @ApiModelProperty("参数组名")
    private String name;
}
