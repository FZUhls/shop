package com.henry.shop.customer.service;

import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.common.base.model.dataobj.usr.Customer;
import com.henry.shop.customer.api.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author henry1
 * 顾客服务类的实现
 */
@Slf4j
@DubboService
public class CustomerServiceImpl implements ProvinceService {
    @Resource
    ProvinceMapper provinceMapper;

    @Override
    public Province getProvinceById(Long id) {
        return provinceMapper.selectById(id);
    }
}
