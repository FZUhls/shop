package com.henry.shop.common.base.enumerate;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henry.shop.common.base.annotation.EnumJson;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 订单状态
 */
@Getter
@AllArgsConstructor
public enum BillStatus implements Enumerator{

    /**
     * 未支付
     */
    NOT_PAY(0,"未付款"),
    /**
     * 等待发货
     */
    WAIT_DELIVER(1,"待发货"),
    /**
     * 已发货等待收获
     */
    TRANSPORT(2,"待收货"),
    /**
     * 已确认收获
     */
    RECEIVE(3,"已收货"),
    /**
     * 订单已结束，超过日期，不再提供退还服务
     */
    FINISH(4,"已结束"),
    /**
     * 订单已取消
     */
    CANCEL(-1,"已取消"),
    /**
     * 订单已退货
     */
    RETURN(-2,"已退货");

    @JSONCreator
    public static BillStatus getByCode(Integer code){
        if(code == null){
            return null;
        }
        for(BillStatus items : values()){
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
