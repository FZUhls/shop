package com.henry.shop.common.base.model.com;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.PublishStatus;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 商品表 (SPU)
 */
@Data
@TableName("com_commodity")
public class Commodity {
    private Long id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 类别id
     */
    private Long categoryId;
    /**
     * 规格组id
     */
    private Long variantGroupId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 上架状态
     */
    private PublishStatus publishStatus;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
