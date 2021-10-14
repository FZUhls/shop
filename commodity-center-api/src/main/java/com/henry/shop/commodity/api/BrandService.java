package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.commodity.dto.BrandDto;
import com.henry.shop.common.base.exception.BaseException;
import com.henry.shop.common.base.model.dataobj.com.Brand;

import java.util.List;

/**
 * @author Henry
 */
public interface BrandService {
    /**
     * 批量新增品牌
     * @param brandVoList
     * @return
     */
    int addBrandBranch(List<BrandDto> brandVoList);

    /**
     * 新增品牌方法
     * @param brandVo 新增品牌Vo
     * @return
     */
    int addBrand(BrandDto brandVo);

    /**
     * 按名查询品牌，支持模糊查询
     * @param name 品牌关键词
     * @param pageNo 页号
     * @param size 页长
     * @return List 品牌列表
     */
    IPage<Brand> findBrandByName(String name, long pageNo, long size);

    /**
     * 分页获取品牌列表
     * @param pageNo 页号
     * @param size 页长
     * @return List 品牌列表
     */
    IPage<Brand> getBrandList(long pageNo, long size);

    /**
     * 根据id查询品牌
     * @param id 品牌id
     * @return Brand id对应的品牌
     */
    Brand findById(long id);

    /**
     * 根据id更新品牌
     * @param id 被更新的品牌id
     * @param brandDto 更新内容
     * @return int 修改的行数
     */
    int update(long id,BrandDto brandDto) throws BaseException;

    /**
     * 根据id删除品牌
     * @param id 删除的id
     * @return int 修改的行数
     */
    int delete(long id) throws BaseException;
}
