package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author henry1
 * 商品sku表
 */
@Data
@TableName("com_sku")
public class ComSKU implements Serializable {
    private Long id;
    /**
     * sku code 具有唯一性
     */
    private String skuCode;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private Integer skuNumber;
}
