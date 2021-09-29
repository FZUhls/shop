package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 类目表
 */
@Data
@TableName("com_category")
public class Category {
    private Long id;
    /**
     * 父类id
     */
    private Long parentId;
    /**
     * 类名
     */
    private String name;
    /**
     * 产品数量
     */
    private Integer productCount;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
