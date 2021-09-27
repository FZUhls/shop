package com.henry.shop.common.base.model.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.ReceiveType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("bil_bill_list")
@ApiModel("订单")
public class BillList {
    private Long id;
    /**
     * 顾客ID
     */
    @ApiModelProperty("顾客id")
    private Long customerId;
    /**
     * 收货方式
     */
    private ReceiveType receiveType;
    /**
     * 发货仓库id
     */
    private Long pickUpStoreId;
    /**
     * 快递单号
     */
    private Long transportId;
    /**
     * 收货地址id
     */
    private Long receiveAddrId;
    /**
     * 顾客备注
     */
    private String customerNote;
    /**
     * 商家备注
     */
    private String note;
    /**
     * 订单原总价
     */
    private BigDecimal totalRowAmount;
    /**
     * 优惠价抵扣金额
     */
    private BigDecimal couponAmount;
    /**
     * 会员积分抵扣金额
    */
    private BigDecimal memScoreAmount;
    /**
     * 各种抵扣之后的总价格
     */
    private BigDecimal totalAmount;
    /**
     * 订单状态 0-未付款 1-待发货 2-待收货 3-已收货
     */
    private Integer billStatus;
    /**
     * 订单来源 0-网上商城 1-移动商城 2-线下门店
     */
    private Integer sourceType;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
