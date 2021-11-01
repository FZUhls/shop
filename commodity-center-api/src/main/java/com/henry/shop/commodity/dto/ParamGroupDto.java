package com.henry.shop.commodity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 */
@ApiModel("参数组dto")
@Data
public class ParamGroupDto implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 参数组名
     */
    private String name;
}
