package com.henry.shop.commodity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("分类dto")
public class CategoryDto implements Serializable {
    /**
     * 父类id
     */
    @ApiModelProperty("父类id")
    private Long parantId;
    /**
     * 名称
     */
    @ApiModelProperty("类名")
    private String name;
    /**
     * 参数组id
     */
    @ApiModelProperty("参数组id")
    private String paramGroupId;
}
