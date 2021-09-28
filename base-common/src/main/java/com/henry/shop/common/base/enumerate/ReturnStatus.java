package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 退货单状态枚举
 */
@AllArgsConstructor
@Getter
public enum ReturnStatus {
    /**
     * 退货订单等待处理
     */
    PENDING(0,"待处理"),
    /**
     * 卖家已同意，等待顾客退款
     */
    WAIT_RETURN(1,"等待退货"),
    /**
     * 顾客已发货，等待商家确认收获
     */
    TRANSPORT(2,"已退货"),
    /**
     * 商家已收货
     */
    RECEIVE(3,"已收货"),
    /**
     * 退货单已结束
     */
    FINISH(4,"已完成"),
    /**
     * 商家已拒绝退货
     */
    REFUSE(-1,"已拒绝");
    @EnumValue
    private final int code;
    private final String label;
}
