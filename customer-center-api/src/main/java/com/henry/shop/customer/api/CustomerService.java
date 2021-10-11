package com.henry.shop.customer.api;

import com.henry.shop.common.base.model.dataobj.location.Province;
import com.henry.shop.common.base.model.dataobj.usr.Customer;

/**
 * @author henry1
 */
public interface CustomerService {
    public Province getProvinceById(Long id);
}
