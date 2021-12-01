package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Henry
 */
@Data
@ApiModel("规格")
public class VariantVo {
    /**
     * 规格名
     */
    @ApiModelProperty("规格名")
    private String name;
    /**
     * 规格组id
     */
    @ApiModelProperty("所属规格组id")
    private long groupId;
}
