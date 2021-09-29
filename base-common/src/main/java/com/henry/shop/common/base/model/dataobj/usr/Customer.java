package com.henry.shop.common.base.model.dataobj.usr;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.CustomerStatus;
import com.henry.shop.common.base.enumerate.Sex;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 顾客表
 */
@Data
@TableName("usr_customer")
public class Customer {
    private Long id;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 密码
     */
    private String passwd;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别  1 为男性，0 为女性
     */
    private Sex sex;
    /**
     * 账户状态 0---无效 1---有效
     */
    private CustomerStatus status;
    /**
     * 头像图片url
     */
    private String iconUrl;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
