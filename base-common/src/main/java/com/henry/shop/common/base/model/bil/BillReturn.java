package com.henry.shop.common.base.model.bil;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry
 * 退货单表
 */
@TableName("bil_return")
@Data
public class BillReturn {
    private Long id;
    /**
     * 对应订单id
     */
    private Long billId;
    /**
     * 退货单状态 0-待处理 1-待退货 2-已完成 3-已拒绝
     */
    private Integer returnStatus;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}