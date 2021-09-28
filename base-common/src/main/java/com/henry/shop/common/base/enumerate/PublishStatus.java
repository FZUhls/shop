package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 上架状态
 */
@AllArgsConstructor
@Getter
public enum PublishStatus {
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
    @EnumValue
    private final int code;
    private final String label;
}
