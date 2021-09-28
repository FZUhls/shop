package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 订单状态
 */
@Getter
@AllArgsConstructor
public enum BillStatus {

    /**
     * 未支付
     */
    NOT_PAY(0,"未付款"),
    /**
     * 等待发货
     */
    WAIT_DELIVER(1,"待发货"),
    /**
     * 已发货等待收获
     */
    TRANSPORT(2,"待收货"),
    /**
     * 已确认收获
     */
    RECEIVE(3,"已收货"),
    /**
     * 订单已结束，超过日期，不再提供退还服务
     */
    FINISH(4,"已结束"),
    /**
     * 订单已取消
     */
    CANCEL(-1,"已取消"),
    /**
     * 订单已退货
     */
    RETURN(-2,"已退货");

    @EnumValue
    private final int code;
    private final String label;
}
