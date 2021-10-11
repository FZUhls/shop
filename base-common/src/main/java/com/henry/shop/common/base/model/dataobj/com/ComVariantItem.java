package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry1
 * SKU规则item
 */
@TableName("com_variant_item")
@Data
public class ComVariantItem implements Serializable {
    private Long id;
    /**
     * 规则项id
     */
    private Long variantId;
    /**
     * sku id
     */
    private Long skuId;
    /**
     * 规格值
     */
    private String variantValue;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
