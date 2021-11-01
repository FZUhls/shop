package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("参数修改表单")
public class ParamEditReq implements Serializable {
    @ApiModelProperty("参数名")
    private String name;
    @ApiModelProperty("参数类型")
    private int type;
    @ApiModelProperty("可选值")
    private String selectValues;
    @ApiModelProperty("序号")
    private byte sort;
}
