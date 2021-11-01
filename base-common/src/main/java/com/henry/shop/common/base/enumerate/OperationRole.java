package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作角色枚举
 * @author henry1
 */
@Getter
@AllArgsConstructor
public enum OperationRole implements Enumerator{
    /**
     * 用户角色
     */
    CUSTOMER(0,"用户"),
    /**
     * 商家角色
     */
    TENANT(1,"商家"),
    /**
     * 系统角色
     */
    SYSTEM(2,"系统");
    @EnumValue
    private final int code;
    private final String label;
}
