package com.henry.shop.common.base.enumerate;

import com.fasterxml.jackson.annotation.JsonValue;
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
     * 系统错误
     */
    SYSTEM_ERROR(500,"系统错误");

    @JsonValue
    private final Integer code;
    private final String description;
}
