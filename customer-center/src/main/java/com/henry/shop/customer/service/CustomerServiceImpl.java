package com.henry.shop.customer.service;

import com.henry.shop.common.base.mapper.location.ProvinceMapper;
import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.common.base.model.dataobj.usr.Customer;
import com.henry.shop.customer.api.CustomerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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
