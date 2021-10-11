package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry1
 * 参数值
 */
@TableName("com_param_item")
@Data
public class ComParamItem implements Serializable {
    private Long id;
    /**
     * 参数项id
     */
    private Long paramId;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 参数值
     */
    private String paramValue;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
