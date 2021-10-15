package com.henry.shop.customer.api;

import com.henry.shop.customer.dto.LoginResponse;
import com.henry.shop.customer.dto.PasswordLoginRequest;
import com.henry.shop.customer.dto.RegisterRequest;
import com.henry.shop.customer.dto.RegisterResponse;

/**
 * @author henry1
 */
public interface CustomerService {
    LoginResponse PassWordLogin(PasswordLoginRequest request);
    RegisterResponse register(RegisterRequest request);
}
