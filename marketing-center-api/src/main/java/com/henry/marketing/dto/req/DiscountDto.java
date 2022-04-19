package com.henry.marketing.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wjh
 * date  2022/4/18
 */
@Data
@ApiModel("折扣dto")
public class DiscountDto implements Serializable {

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commodityName;

    /**
     * 商品ID
     */
    @ApiModelProperty("商品ID")
    private Long commodity_id;

    /**
     * 商品名称
     */
    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 商品名称
     */
    @ApiModelProperty("品牌ID")
    private Long brand_id;

    /**
     * 折扣率
     */
    @ApiModelProperty("折扣率")
    private Double discountRate;

    /**
     * 是否开启折扣
     */
    @ApiModelProperty("是否开启折扣")
    private Boolean enable;

}

