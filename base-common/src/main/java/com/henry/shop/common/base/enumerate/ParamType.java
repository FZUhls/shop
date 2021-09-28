package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 商品参数类型枚举
 */
@Getter
@AllArgsConstructor
public enum ParamType {
    /**
     * 单选参数
     */
    SINGLE_SELECT(0,"单选"),
    /**
     * 多选参数
     */
    MULTI_SELECT(1,"多选"),
    /**
     * 可自定义输入
     */
    INPUT(2,"输入");

    @EnumValue
    private final int code;
    private final String  label;
}
