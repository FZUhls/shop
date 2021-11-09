package com.henry.shop.business.commodity.vo.req;

import com.henry.shop.common.base.enumerate.ParamType;
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
    /**
     * 参数名
     */
    @ApiModelProperty("参数名")
    private String name;
    /**
     * 参数组id
     */
    @ApiModelProperty("参数组id")
    private long groupId;
    /**
     * 参数类型
     */
    @ApiModelProperty(value = "参数类型",allowableValues = "0,1,2")
    private ParamType type;
    /**
     * 可选值,逗号隔开
     */
    @ApiModelProperty("可选值，逗号隔开")
    private String selectValues;
    /**
     *
     */
    @ApiModelProperty("序号")
    private byte sort;
}
