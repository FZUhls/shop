package com.henry.shop.customer.dto;

import lombok.Data;

/**
 * @author henry1
 */
@Data
public class PasswordLoginRequest {
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 加密的密码
     */
    private String encryPwd;
    /**
     * 短信验证码
     */
    private String smsCode;
    /**
     * 图型验证码
     */
    private String imageVertify;
}
