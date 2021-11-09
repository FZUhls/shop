package com.henry.shop.common.base.exception;

/**
 * 数据不存在异常
 * @author Henry
 */
public class DataBaseNotFoundException extends Exception{
   public DataBaseNotFoundException(){
       super("数据不存在");
   }
}
