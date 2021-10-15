package com.henry.shop.commodity.dto;

import com.henry.shop.common.base.enumerate.ParamType;
import lombok.Data;

import java.util.List;

/**
 * @author Henry
 */
@Data
public class ParamDto {
    /**
     * 参数组id
     */
    private Long paramGroupId;
    /**
     * 参数名
     */
    private String name;
    /**
     * 参数类型
     */
    private ParamType type;
    /**
     * 可选内容
     */
    private List<String> selectValue;
}
