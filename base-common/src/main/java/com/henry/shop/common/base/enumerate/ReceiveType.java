package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author henry1
 * 收获方式枚举类
 */
public enum ReceiveType{
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
    ReceiveType(Integer code,String label){
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }
}
