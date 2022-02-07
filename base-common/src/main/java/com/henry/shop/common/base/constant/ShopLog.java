package com.henry.shop.common.base.constant;

import lombok.Data;

import java.util.Map;

/**
 * @author Henry
 */
@Data
public class ShopLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 消耗时间
     */
    private Long spendTime;

    /**
     * 请求类型
     */
    private String httpMethod;

    /**
     * controller类型名
     */
    private String className;

    /**
     * controller方法名
     */
    private String methodName;

    /**
     * 请求方IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Map<String,String []> parameter;

    /**
     * 状态
     */
    private String code;

    private String msg;
}
