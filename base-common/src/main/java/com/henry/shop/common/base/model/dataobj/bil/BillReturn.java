package com.henry.shop.common.base.model.dataobj.bil;


import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.ReturnStatus;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author henry
 * 退货单表
 */
@TableName("bil_return")
@Data
public class BillReturn implements Serializable {
    private Long id;
    /**
     * 对应订单id
     */
    private Long billId;
    /**
     * 退款总金额
     */
    private BigDecimal returnAmount;
    /**
     * 退货单状态 0-待处理 1-待退货 2-已完成 3-已拒绝
     */
    private ReturnStatus returnStatus;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
