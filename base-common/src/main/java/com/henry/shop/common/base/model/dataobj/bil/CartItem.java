package com.henry.shop.common.base.model.dataobj.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author henry
 * 购物车item表
 */
@Data
@TableName("bil_cart_item")
public class CartItem implements Serializable {
    private Long id;
    /**
     * 顾客id
     */
    private Long usrId;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * 商品单价
     */
    private BigDecimal commodityPrice;
    /**
     * 商品数量
     */
    private Integer commodityNumber;
}
