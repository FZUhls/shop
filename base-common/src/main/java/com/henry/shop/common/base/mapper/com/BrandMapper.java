package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author henry1
 * 品牌 mapper类
 */
public interface BrandMapper extends BaseMapper<Brand> {
    int insertBranch(@Param("brandList")List<Brand> brandList);
    IPage<Brand> getByPageAndName(Page<?> page, @Param("keyword") String keyword);
}
