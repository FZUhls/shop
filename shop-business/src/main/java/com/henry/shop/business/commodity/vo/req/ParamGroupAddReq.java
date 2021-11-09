package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel("参数组添加表单")
public class ParamGroupAddReq implements Serializable {
    /**
     * 参数组名
     */
    @ApiModelProperty("参数组名")
    @NotNull(message = "参数组名不可为空")
    String name;
}
