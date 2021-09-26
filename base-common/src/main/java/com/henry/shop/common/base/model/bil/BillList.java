package com.henry.shop.common.base.model.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("bil_bill_list")
public class BillList {
    private Long id;
    /**
     * 客户ID
     */
    private Long customerId;
    /**
     * 收获方式
     */
    private Byte receiveType;
    private Long pickUpStoreId;
    private Long transportId;
    private Long receiveAddrId;
    private String customerNote;
    private String note;

    /**
     * 订单原总价
     */
    private BigDecimal totalRowAmount;
    /**
     * 优惠价抵扣金额
     */
    private BigDecimal couponAmount;
    /**
     * 会员积分抵扣金额
    */
    private BigDecimal memScoreAmount;
    /**
     * 各种抵扣之后的总价格
     */
    private BigDecimal totalAmount;
}
