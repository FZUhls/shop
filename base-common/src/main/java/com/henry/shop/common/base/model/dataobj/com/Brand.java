package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 品牌表
 */
@TableName("com_brand")
@Data
public class Brand {
    private Long id;
    /**
     * 品牌code，唯一性
     */
    private String brandCode;
    /**
     * 品牌名
     */
    private String brandName;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
