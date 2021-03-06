package com.henry.shop.common.base.model.dataobj.bil;

import com.baomidou.mybatisplus.annotation.TableName;
import com.henry.shop.common.base.enumerate.BillStatus;
import com.henry.shop.common.base.enumerate.OperationRole;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry1
 */
@Data
@TableName("bil_bill_history")
public class BillHistory implements Serializable {
    private Long id;
    private Long billId;
    private BillStatus changeStatus;
    private OperationRole operRole;
    private Date creTime;
}
