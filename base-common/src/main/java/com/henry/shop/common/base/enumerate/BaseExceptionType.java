package com.henry.shop.common.base.enumerate;

import com.henry.shop.common.base.exception.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author henry1
 * 基础异常枚举
 */
@Getter
@AllArgsConstructor
public enum BaseExceptionType {
    /**
     * 插入的数目大于预期
     */
    SQL_WRONG_INSERT("00000","sql插入异常"),
    ENTITY_NOT_FOUND("00001","修改的内容不存在");

    private final String code;
    private final String message;

    public BaseException newBaseException(){
        return new BaseException(this);
    }
}
