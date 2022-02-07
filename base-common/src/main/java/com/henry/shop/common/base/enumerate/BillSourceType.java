package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 订单来源
 */
@Getter
@AllArgsConstructor
public enum BillSourceType implements Enumerator {
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

    @JSONCreator
    public static BillSourceType getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(BillSourceType items : values()){
            if(items.code.equals(code)){
                return items;
            }
        }
        return null;
    }

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String label;
}
