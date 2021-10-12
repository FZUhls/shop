package com.henry.shop.common.manager.impl;

import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.common.base.model.dataobj.usr.Customer;
import com.henry.shop.common.manager.CustomerManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author Henry
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerManagerImpl implements CustomerManager {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int insert(Customer newCustomer){
        log.info("插入顾客信息====\n顾客信息 = [{}]",newCustomer);
        return customerMapper.insert(newCustomer);
    }

    @Override
    public int update(Customer newCustomer) {
        Customer oldCustomer = customerMapper.selectById(newCustomer.getId());
        Assert.isNull(oldCustomer,"顾客id不存在");
        log.info("更新顾客信息====\n旧的信息 = [{}]\n新的信息 = [{}]",oldCustomer,newCustomer);
        return customerMapper.updateById(newCustomer);
    }
}
