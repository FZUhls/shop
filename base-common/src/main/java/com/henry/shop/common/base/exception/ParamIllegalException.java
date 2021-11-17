package com.henry.shop.common.base.exception;

/**
 * 商品参数非法异常
 * @author Henry
 */
public class ParamIllegalException extends Exception{
    public ParamIllegalException(){
        super("商品参数不合法");
    }
    public ParamIllegalException(String msg){
        super(msg);
    }
}
