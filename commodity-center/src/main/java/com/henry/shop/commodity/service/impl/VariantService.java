package com.henry.shop.commodity.service.impl;

import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;

/**
 * @author Henry
 */
public interface VariantService {

    /**
     * 根据id获取规格组
     * @param groupId 规格组id
     * @return ComVariantGroup规格组
     */
    ComVariantGroup getVariantGroupById(long groupId);

    /**
     * 根据id获取规格
     * @param id 规格id
     * @return ComVariantGroup
     */
    ComVariant getVariantById(long id);

    ComVariantGroup createVariantGroup();

    ComVariant createVariant();

    ComVariantGroup updateVariantGroup();

    ComVariant updateVariant();

    void deleteVariantGroup(long id);

    void deleteVariant(long id);
}
