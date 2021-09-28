package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 性别枚举
 */
@Getter
@AllArgsConstructor
public enum Sex {

    /**
     * 男士
     */
    MALE(1,"男性"),
    /**
     * 女士
     */
    FEMALE(0,"女性");

    @EnumValue
    private final int code;
    private final String msg;
}
