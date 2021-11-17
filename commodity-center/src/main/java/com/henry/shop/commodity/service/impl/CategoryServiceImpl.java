package com.henry.shop.commodity.service.impl;

import com.henry.shop.commodity.service.CategoryService;
import com.henry.shop.common.base.mapper.com.CategoryParamGroupRelaMapper;
import com.henry.shop.common.base.model.dataobj.com.CategoryParamGroupRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryParamGroupRelaMapper categoryParamGroupRelaMapper;
    @Override
    public List<CategoryParamGroupRelation> selectRelationByCategoryId(long id) {
        return categoryParamGroupRelaMapper.selectByCategoryId(id);
    }
}
