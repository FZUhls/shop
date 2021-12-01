package com.henry.shop.common.base.exception;

/**
 * @author Henry
 */
public class VariantException extends Exception{
    public VariantException(){
        super("商品规格异常");
    }
    public VariantException(Throwable throwable){
        super("商品规格异常",throwable);
    }
    public VariantException(String msg){
        super(msg);
    }
    public VariantException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
