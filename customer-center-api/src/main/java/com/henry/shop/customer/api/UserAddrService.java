package com.henry.shop.customer.api;

import com.henry.shop.common.base.model.dataobj.usr.UsrAddress;
import com.henry.shop.customer.dto.AddressDto;

import java.util.List;

/**
 * @author henry1
 */
public interface UserAddrService {
    /**
     * @param id 顾客id
     * @return List<UsrAddress> 顾客的所有收货地址
     */
    List<UsrAddress> getUsrAddressByCusId(Long id);

    /**
     * @param addressDto 地址表单
     * @return Long 返回自增主键
     */
    Long addUserAddress(AddressDto addressDto);

    /**
     * @param id 收获地址id
     * @param addressDto 更改的详情
     * @return Long 返回修改的id
     */
    Long editUserAddress(Long id, AddressDto addressDto);

    /**
     * @param id 用户收获地址id
     */
    void removeUserAddress(Long id);
}
