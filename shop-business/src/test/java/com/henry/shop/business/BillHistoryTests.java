package com.henry.shop.business;

import com.henry.shop.common.base.enumerate.BillStatus;
import com.henry.shop.common.base.enumerate.OperationRole;
import com.henry.shop.common.base.mapper.bil.BillHistoryMapper;
import com.henry.shop.common.base.model.bil.BillHistory;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import javax.annotation.Resource;
import java.util.Date;

@Log
class BillHistoryTests extends BaseTest{

    @Resource
    BillHistoryMapper billHistoryMapper;

    @Test
    void InsertTest(){
        BillHistory billHistory = new BillHistory();
        billHistory.setBillId(1L);
        billHistory.setChangeStatus(BillStatus.RECEIVE);
        billHistory.setOperRole(OperationRole.SYSTEM);
        billHistory.setCreTime(new Date());
        log.info(billHistory.toString());
        billHistoryMapper.insert(billHistory);
    }
    @Test
    void SelectTest1(){
        BillHistory billHistory = billHistoryMapper.selectById(2L);
        log.info(billHistory.toString());
    }
}
