package com.henry.shop.common.base.exception;

/**
 * @author Henry
 */
public abstract class AbstractException extends Exception{
    public AbstractException(String msg){
        super(msg);
    }
    public AbstractException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
