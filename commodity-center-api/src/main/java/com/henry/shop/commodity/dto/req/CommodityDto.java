package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品添加表单
 * @author Henry
 */
@Data
@ApiModel("商品dto")
public class CommodityDto implements Serializable {
    /**
     * 参数组名
     */
    @ApiModelProperty("参数组名")
    private String name;
    /**
     * 分类
     */
    @ApiModelProperty("类别id")
    private Long categoryId;
    /**
     * 规格组id
     */
    @ApiModelProperty("规格组id")
    private Long variantGropuId;

}
