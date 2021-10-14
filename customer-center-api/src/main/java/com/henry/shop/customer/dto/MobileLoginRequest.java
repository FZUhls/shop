package com.henry.shop.customer.dto;

import lombok.Data;

/**
 * @author henry1
 * 登录请求表单
 */
@Data
public class MobileLoginRequest {
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 短信验证码
     */
    private String smsCode;
}
