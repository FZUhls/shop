package com.henry.shop.common.base.model.dataobj.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.OperationRole;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry
 * 退货状态变化表
 */
@TableName("bil_return_history")
@Data
public class BillReturnHistory implements Serializable {
    private Long id;
    /**
     * 退货单id
     */
    private Long returnId;
    /**
     * 操作着者 0-用户 1-商家 2-系统
     */
    private OperationRole operRole;
    /**
     * 状态变化 0-待处理 1-待退货 2-已完成 3-已拒绝
     */
    private Integer changeStatus;
    private Date creTime;
}
