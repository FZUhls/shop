package com.henry.shop.customer.dto;

import lombok.Data;

/**
 * @author henry1
 * 注册请求表单
 */
@Data
public class RegisterRequest {
    private String phone;
    private String encryPwd;
    private String nickName;
}
