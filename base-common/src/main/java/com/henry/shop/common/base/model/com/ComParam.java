package com.henry.shop.common.base.model.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 商品参数表
 */
@Data
@TableName("com_param")
public class ComParam {
    private Long id;
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
    private Integer type;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
