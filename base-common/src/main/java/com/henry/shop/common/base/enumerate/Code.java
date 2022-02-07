package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henry.shop.common.base.annotation.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应代码枚举
 * @author Henry
 */
@Getter
@AllArgsConstructor
public enum Code implements Enumerator{
    /**
     * 请求成功
     */
    SUCCESS(200,"请求成功"),
    /**
     * 请求失败
     */
    FAIL(300,"请求失败"),
    /**
     * 请求错误
     */
    SYSTEM_ERROR(500,"请求错误");

    @JSONCreator
    public static Code getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(Code items : values()){
            if(items.code.equals(code)){
                return items;
            }
        }
        return null;
    }

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String description;
}
