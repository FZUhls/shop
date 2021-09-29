package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 参数组实体类
 */
@Data
@TableName("com_param_group")
public class ComParamGroup {
    private Long id;
    /**
     * 参数组名
     */
    private String name;
    /**
     * 参数数量
     */
    private Integer num;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
