package com.henry.shop.commodity.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CategoryDto;
import com.henry.shop.commodity.service.CategoryService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.mapper.com.CategoryMapper;
import com.henry.shop.common.base.mapper.com.CategoryParamGroupRelaMapper;
import com.henry.shop.common.base.model.dataobj.com.Category;
import com.henry.shop.common.base.model.dataobj.com.CategoryParamGroupRelation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryParamGroupRelaMapper categoryParamGroupRelaMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryParamGroupRelation> selectRelationByCategoryId(long id) {
        return categoryParamGroupRelaMapper.selectByCategoryId(id);
    }

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto,category);
        category.setCreTime(new Date());
        category.setUpdTime(new Date());
        categoryMapper.insert(category);
        Map<Long, String> paramGroupMap = categoryDto.getParamGroupMap();
        for (Map.Entry<Long, String> entry : paramGroupMap.entrySet()) {
            Long paramGroupId = entry.getKey();
            String alias = entry.getValue();
            CategoryParamGroupRelation relation = new CategoryParamGroupRelation();
            relation.setCategoryId(category.getId());
            relation.setAlias(alias);
            relation.setParamGroupId(paramGroupId);
            relation.setCreTime(new Date());
            relation.setUpdTime(new Date());
            categoryParamGroupRelaMapper.insert(relation);
        }
        return category;
    }

    @Override
    public Category updateCategory(long id,CategoryDto categoryDto) throws DataNotFoundException {
        Category categoryOld = categoryMapper.selectById(id);
        if(Objects.isNull(categoryDto)){
            throw new DataNotFoundException();
        }
        BeanUtils.copyProperties(categoryDto,categoryOld);
        List<CategoryParamGroupRelation> categoryParamGroupRelations = categoryParamGroupRelaMapper.selectByCategoryId(id);
        categoryParamGroupRelaMapper.deleteBatchIds(categoryParamGroupRelations.stream().map(CategoryParamGroupRelation::getId).collect(Collectors.toList()));
        Map<Long, String> paramGroupMap = categoryDto.getParamGroupMap();
        for (Map.Entry<Long, String> entry : paramGroupMap.entrySet()) {
            Long paramGroupId = entry.getKey();
            String alias = entry.getValue();
            CategoryParamGroupRelation relation = new CategoryParamGroupRelation();
            relation.setCategoryId(id);
            relation.setAlias(alias);
            relation.setParamGroupId(paramGroupId);
            relation.setCreTime(new Date());
            relation.setUpdTime(new Date());
            categoryParamGroupRelaMapper.insert(relation);
        }
        categoryMapper.updateById(categoryOld);
        return categoryOld;
    }

    @Override
    public Category selectById(long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public Page<Category> selectByPage(long pageNo, long size, String keyword) {
        Page<Category> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(size);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if(StrUtil.isNotBlank(keyword)){
            wrapper.like("name",keyword);
        }
        return categoryMapper.selectPage(page, wrapper);
    }

    @Override
    public Page<Category> selectByPage(long pageNo, long size) {
        return selectByPage(pageNo,size,null);
    }

    @Override
    public void deleteById(long id) throws DataNotFoundException {
        Category category = categoryMapper.selectById(id);
        if(Objects.isNull(category)){
            throw new DataNotFoundException();
        }
        categoryMapper.deleteById(category);
    }
}
