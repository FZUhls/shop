package com.henry.shop.common.base.model.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 类目和参数组关联表
 */
@Data
@TableName("com_category_param_group_relation")
public class CategoryParamGroupRelation {
    private Long id;
    /**
     * 类目id
     */
    private Long categoryId;
    /**
     * 参数组id
     */
    private Long paramGroupId;
    /**
     * 类目别名
     */
    private String alias;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
