package com.henry.shop.common.base.enumerate;

import com.baomidou.mybatisplus.annotation.EnumValue;
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
    @EnumValue
    private final Integer code;
    private final String label;
}
