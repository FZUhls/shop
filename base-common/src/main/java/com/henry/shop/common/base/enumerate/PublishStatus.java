package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henry.shop.common.base.annotation.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 上架状态
 */
@AllArgsConstructor
@Getter
public enum PublishStatus implements Enumerator{
    /**
     * 商品未上架
     */
    WAIT_SALE(-1,"未上架"),
    /**
     * 商品已上架
     */
    ON_SALE(1,"已上架"),
    /**
     * 商品已下架
     */
    BAN(0,"已下架");

    @JSONCreator
    public static PublishStatus getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(PublishStatus items : values()){
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
