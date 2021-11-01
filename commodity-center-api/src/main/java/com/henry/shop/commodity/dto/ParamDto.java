package com.henry.shop.commodity.dto;

import com.henry.shop.common.base.enumerate.ParamType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("参数dto")
public class ParamDto implements Serializable {
    /**
     * 参数组id
     */
    @ApiModelProperty("参数组id")
    private Long paramGroupId;
    /**
     * 参数名
     */
    @ApiModelProperty("参数名")
    private String name;
    /**
     * 参数类型
     */
    @ApiModelProperty("参数类型")
    private ParamType type;
    /**
     * 序号
     */
    @ApiModelProperty("参数序号")
    private int sort;
    /**
     * 可选内容
     */
    @ApiModelProperty("可选内容")
    private String selectValue;
}
