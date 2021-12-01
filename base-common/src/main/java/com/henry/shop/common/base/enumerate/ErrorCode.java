package com.henry.shop.common.base.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;
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
    @JsonValue
    private final Integer code;
    private final String description;
}
