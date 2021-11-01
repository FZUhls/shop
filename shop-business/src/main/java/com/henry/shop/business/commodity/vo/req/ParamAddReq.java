package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("参数表单")
public class ParamAddReq implements Serializable {
    @ApiModelProperty("参数名")
    private String name;
    @ApiModelProperty("参数组id")
    private long groupId;
    @ApiModelProperty(value = "参数类型",allowableValues = "0,1,2")
    private int type;
    @ApiModelProperty("可选值")
    private String selectValues;
    @ApiModelProperty("序号")
    private byte sort;
}
