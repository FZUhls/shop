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
    NO_PERMIT(0001,"无权限"),
    ;
    @JsonValue
    private final Integer code;
    private final String description;
}
