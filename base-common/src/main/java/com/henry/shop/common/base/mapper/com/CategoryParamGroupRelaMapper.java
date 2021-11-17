package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.com.CategoryParamGroupRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author henry1
 * 类目参数组关联表 mapper类
 */
public interface CategoryParamGroupRelaMapper extends BaseMapper<CategoryParamGroupRelation> {
    List<CategoryParamGroupRelation> selectByCategoryId(@Param("categoryId") long categoryId);
}
