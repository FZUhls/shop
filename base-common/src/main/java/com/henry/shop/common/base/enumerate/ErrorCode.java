package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henry.shop.common.base.annotation.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Henry
 */

@Getter
@AllArgsConstructor
public enum ErrorCode implements Enumerator{
    /**
     * 无操作权限
     */
    NO_PERMIT(0001,"无权限"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(9999,"系统错误")
    ;

    @JSONCreator
    public static ErrorCode getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(ErrorCode items : values()){
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
