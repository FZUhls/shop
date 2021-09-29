package com.henry.shop.common.base.model.dataobj.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author henry
 * 订单单品表
 */
@Data
@TableName("bil_bill_item")
@ApiModel("订单item")
public class BillItem {
    private Long id;
    /**
     * 订单id
     */
    @ApiModelProperty("订单号")
    private Long billId;
    /**
     * SKU id
     */
    @ApiModelProperty("SKUid")
    private Long skuId;
    /**
     * 商品价格
     */
    @ApiModelProperty("产品价格")
    private BigDecimal skuPrice;
    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private Integer number;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date creTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updTime;
}
