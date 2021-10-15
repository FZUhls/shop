package com.henry.shop.commodity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.util.List;

/**
 * @author Henry
 */
@ApiModel("参数组dto")
@Data
public class ParamGroupDto {
    /**
     * id
     */
    private Long id;
    /**
     * 参数组名
     */
    private String name;
    /**
     * 参数列表
     */
    private List<ParamDto> params;
}
