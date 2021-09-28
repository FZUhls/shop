package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 顾客账户状态枚举
 */
@AllArgsConstructor
@Getter
public enum CustomerStatus {
    /**
     * 账号有效
     */
    VALID(1,"有效"),
    /**
     * 账号无效
     */
    INVALID(0,"无效");
    @EnumValue
    private final int code;
    private final String label;
}
