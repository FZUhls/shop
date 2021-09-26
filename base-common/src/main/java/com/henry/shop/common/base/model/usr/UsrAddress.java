package com.henry.shop.common.base.model.usr;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 顾客收获地址表
 */
@TableName("usr_addr")
@Data
public class UsrAddress {
    private Long id;
    /**
     * 顾客id
     */
    private Long customerId;
    /**
     * 收货人姓名
     */
    private String receiveName;
    /**
     * 收获电话
     */
    private String receivePhone;
    /**
     * 国家id
     */
    private Integer countryId;
    /**
     * 省id
     */
    private Integer provinceId;
    /**
     * 市id
     */
    private Integer cityId;
    /**
     * 县id
     */
    private Integer countyId;
    /**
     * 详细地址
     */
    private String addrDetail;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
