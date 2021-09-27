package com.henry.shop.common.base.model.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author henry
 * 订单单品表
 */
@Data
@TableName("bil_bill_item")
@ApiModel
public class BillItem {
    private Long id;
    /**
     * 订单id
     */
    private Long billId;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    private Integer productNumber;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
