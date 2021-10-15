package com.henry.shop.customer.service;

import com.henry.shop.common.base.mapper.usr.CustomerMapper;
import com.henry.shop.customer.api.CustomerService;
import com.henry.shop.customer.dto.LoginResponse;
import com.henry.shop.customer.dto.PasswordLoginRequest;
import com.henry.shop.customer.dto.RegisterRequest;
import com.henry.shop.customer.dto.RegisterResponse;
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
    CustomerMapper customerMapper;

    @Override
    public LoginResponse PassWordLogin(PasswordLoginRequest request) {
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return null;
    }
}
