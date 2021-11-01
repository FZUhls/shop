package com.henry.shop.common.base.exception;

/**
 * @author Henry
 * 数据不存在异常
 */
public class DataBaseNotFoundException extends Exception{
   public DataBaseNotFoundException(){
       super("数据不存在");
   }
}
