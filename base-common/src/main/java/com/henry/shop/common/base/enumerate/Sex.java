package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
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

    @JSONCreator
    public static Sex getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(Sex items : values()){
            if(items.code.equals(code)){
                return items;
            }
        }
        return null;
    }

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String msg;
}
