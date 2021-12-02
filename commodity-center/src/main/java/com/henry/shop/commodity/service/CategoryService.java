package com.henry.shop.commodity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CategoryDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.model.dataobj.com.Category;
import com.henry.shop.common.base.model.dataobj.com.CategoryParamGroupRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 类别service
 * @author Henry
 */
public interface CategoryService {
    /**
     * @param id 分类id
     * @return 分类与参数组对应关系
     */
    List<CategoryParamGroupRelation> selectRelationByCategoryId(long id);

    /**
     * 创新新的分类
     * @param categoryDto 分类dto
     * @return 分类
     */
    @Transactional(rollbackFor = Exception.class)
    Category createCategory(CategoryDto categoryDto);

    /**
     * 更新已有类别
     * @param categoryDto 分裂dto
     * @return 更新后的分类
     * @throws DataNotFoundException
     */
    @Transactional(rollbackFor = Exception.class)
    Category updateCategory(long id, CategoryDto categoryDto) throws DataNotFoundException;

    /**
     * @param id 根据分类id查询类别
     * @return 类别
     */
    Category selectById(long id);

    /**
     * 关键词分页查询
     * @param pageNo 页号
     * @param size 页长
     * @param keyword 关键字
     * @return 分页查询结果
     */
    Page<Category> selectByPage(long pageNo,long size,String keyword);

    /**
     * 分页查询
     * @param pageNo 页号
     * @param size 页长
     * @return 分页查询结果
     */
    Page<Category> selectByPage(long pageNo,long size);

    /**
     * 根据id删除类别
     * @param id 分类id
     * @throws DataNotFoundException 类别不存在
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteById(long id) throws DataNotFoundException;
}
