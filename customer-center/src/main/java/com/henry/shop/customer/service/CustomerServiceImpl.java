package com.henry.shop.customer.service;

import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.customer.api.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author henry1
 * 顾客服务类的实现
 */
@Slf4j
@DubboService
public class CustomerServiceImpl implements CustomerService {
    @Resource
    ProvinceMapper provinceMapper;
    @Override
    public Province getProvinceById(Long id) {
        return provinceMapper.selectById(id);
    }
}
