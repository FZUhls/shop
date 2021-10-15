package com.henry.shop.customer.dto;

import com.henry.shop.common.base.enumerate.CustomerStatus;
import lombok.Data;
/**
 * @author Henry
 */
@Data
public class CustomerDto {
    private Long id;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像图片url
     */
    private String iconUrl;
    /**
     * 账户状态 0---无效 1---有效
     */
    private CustomerStatus status;
}
