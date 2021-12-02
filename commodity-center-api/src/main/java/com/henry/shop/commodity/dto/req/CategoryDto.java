package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Henry
 */
@Data
@ApiModel("分类dto")
public class CategoryDto implements Serializable {
    /**
     * 父类id
     */
    @ApiModelProperty(value = "父类id",notes = "不指定父类的时候默认为一级分类")
    private Long parantId;
    /**
     * 名称
     */
    @ApiModelProperty("类名")
    private String name;
    /**
     * 参数组id
     */
    @ApiModelProperty("关联的参数组与别名")
    private Map<Long,String > paramGroupMap;
}
