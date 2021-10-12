package com.henry.shop.common.manager;

import com.henry.shop.common.base.model.dataobj.usr.Customer;

/**
 * @author Henry
 */
public interface CustomerManager {
    /**
     * @param newCustomer 新的用户对象
     * @return int 返回主键
     */
    int insert(Customer newCustomer);

    /**
     * @param customer
     * @return
     */
    int update(Customer customer);
}
