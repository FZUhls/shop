package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 收获方式枚举类
 */
@Getter
@AllArgsConstructor
public enum ReceiveType implements Enumerator{
    /**
     * 提货方式--物流
     */
    EXPRESS(0,"物流"),
    /**
     * 提货方式--门店自提
     */
    SELF_PICKUP(1,"门店自提");
    @EnumValue
    private final Integer code;
    private final String label;
}
