package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henry.shop.common.base.annotation.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 会员账户状态枚举
 */
@Getter
@AllArgsConstructor
public enum MemberStatus implements Enumerator{
    /**
     * 会员有效
     */
    VALID(1,"有效"),
    /**
     * 会员无效
     */
    INVALID(0,"无效");

    @JSONCreator
    public static MemberStatus getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(MemberStatus items : values()){
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
