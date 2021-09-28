package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 订单来源
 */
@Getter
@AllArgsConstructor
public enum BillSourceType {
    /**
     * PC商城
     */
    PC_MALL(0,"网上商城"),
    /**
     * 移动商城
     */
    MOBILE_MALL(1,"移动商城"),
    /**
     * 线下门店
     */
    OUTLINE_SHOP(2,"线下门店");

    @EnumValue
    private final int code;
    private final String label;
}
