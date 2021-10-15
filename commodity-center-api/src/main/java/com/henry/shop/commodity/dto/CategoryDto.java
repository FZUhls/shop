package com.henry.shop.commodity.dto;

import lombok.Data;

/**
 * @author Henry
 */
@Data
public class CategoryDto {
    /**
     * 父类id
     */
    private Long parantId;
    /**
     * 名称
     */
    private String name;
    /**
     * 参数组id
     */
    private String paramGroupId;
}
