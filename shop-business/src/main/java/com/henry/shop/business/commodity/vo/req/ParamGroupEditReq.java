package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@Data
@ApiModel("参数组修改表单")
public class ParamGroupEditReq implements Serializable {
    @ApiModelProperty("参数组名")
    private String name;
}
