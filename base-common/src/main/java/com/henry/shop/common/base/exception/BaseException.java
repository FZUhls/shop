package com.henry.shop.common.base.exception;

import com.henry.shop.common.base.enumerate.BaseExceptionType;

/**
 * @author Henry
 * shop 系统基础异常类
 */
public class BaseException extends Exception{
    /**
     * 异常码
     */
    private String code;
    public BaseException(String code, String message, Throwable cause){
        super(message,cause);
        this.code = code;
    }
    public BaseException(String code,String message){
        super(message);
        this.code = code;
    }
    public BaseException(BaseExceptionType baseExceptionType){
        super(baseExceptionType.getMessage());
        this.code = baseExceptionType.getCode();
    }
}
