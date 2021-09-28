package com.henry.shop.common.base.model.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 规格项表
 */
@TableName("com_variant")
@Data
public class ComVariant {
    private Long id;
    /**
     * 规格名
     */
    private String name;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
