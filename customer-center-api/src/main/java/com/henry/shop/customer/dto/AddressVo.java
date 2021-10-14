package com.henry.shop.customer.dto;

import lombok.Data;

/**
 * 收获地址表单
 * @author henry1
 */
@Data
public class AddressVo{
    /**
     * 客户id
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
}
