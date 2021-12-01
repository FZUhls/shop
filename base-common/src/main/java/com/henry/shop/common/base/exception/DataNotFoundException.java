package com.henry.shop.common.base.exception;

/**
 * 数据不存在异常
 * @author Henry
 */
public class DataNotFoundException extends Exception{
   public DataNotFoundException(){
       super("数据不存在");
   }
   public DataNotFoundException(String msg){
       super(msg);
   }
}
