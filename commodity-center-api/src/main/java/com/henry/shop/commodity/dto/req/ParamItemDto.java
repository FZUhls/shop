package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>参数项 dto</p>
 * @see com.henry.shop.common.base.model.dataobj.com.ComParamItem
 * @author Henry
 */
@Data
@ApiModel("商品参数item")
public class ParamItemDto {
    /**
     * 参数项id
     */
    @ApiModelProperty("参数id")
    private long paramId;

    /**
     * 值
     */
    @ApiModelProperty("参数值")
    private String value;
}
