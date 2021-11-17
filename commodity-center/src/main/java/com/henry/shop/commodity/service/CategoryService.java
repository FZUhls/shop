package com.henry.shop.commodity.service;

import com.henry.shop.common.base.model.dataobj.com.CategoryParamGroupRelation;

import java.util.List;

/**
 * @author Henry
 */
public interface CategoryService {
    List<CategoryParamGroupRelation> selectRelationByCategoryId(long id);
}
