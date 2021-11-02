package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 性别枚举
 */
@Getter
@AllArgsConstructor
public enum Sex implements Enumerator{

    /**
     * 男士
     */
    MALE(1,"男性"),
    /**
     * 女士
     */
    FEMALE(0,"女性");

    @EnumValue
    private final Integer code;
    private final String msg;
}
