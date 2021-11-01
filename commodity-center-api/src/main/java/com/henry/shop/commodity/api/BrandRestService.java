package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.commodity.dto.BrandDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry
 */
@Component
@FeignClient(value = "commodity-center")
public interface BrandRestService {
    /**
     * 批量新增品牌
     * @param brandVoList
     * @return
     */
    String BASE_URL = "/commodity/brand";
    String ADD_BRAND = BASE_URL + "/add-brand";
    String SELECT_BRAND = BASE_URL + "/find-brands";
    String SELECT_BRAND_BY_NAME = BASE_URL + "/findByName";
    String SELECT_BY_ID = BASE_URL + "/findById/{id}";
    String UPDATE_BY_ID = BASE_URL + "/update/{id}";
    String DELETE_BY_ID = BASE_URL + "/delete/{id}";

    /**
     * 新增品牌方法
     * @param brandVo 新增品牌Vo
     * @return
     */
    @PostMapping(ADD_BRAND)
    BaseResponse<Integer> addBrand(BrandDto brandVo);

    /**
     * 按名查询品牌，支持模糊查询
     * @param name 品牌关键词
     * @param pageNo 页号
     * @param size 页长
     * @return List 品牌列表
     */
    @GetMapping(SELECT_BRAND_BY_NAME)
    BaseResponse<IPage<Brand>> findBrandByName(String name, long pageNo, long size);

    /**
     * 分页获取品牌列表
     * @param pageNo 页号
     * @param size 页长
     * @return List 品牌列表
     */
    @GetMapping(SELECT_BRAND)
    BaseResponse<IPage<Brand>> getBrandList(long pageNo, long size);

    /**
     * 根据id查询品牌
     * @param id 品牌id
     * @return Brand id对应的品牌
     */
    @GetMapping(SELECT_BY_ID)
    BaseResponse<Brand> findById(@PathVariable("id") long id);

    /**
     * 根据id更新品牌
     * @param id 被更新的品牌id
     * @param brandDto 更新内容
     * @return int 修改的行数
     */
    @PutMapping(UPDATE_BY_ID)
    BaseResponse<Integer> update(@PathVariable("id") long id,BrandDto brandDto);

    /**
     * 根据id删除品牌
     * @param id 删除的id
     * @return int 修改的行数
     */
    @DeleteMapping(DELETE_BY_ID)
    BaseResponse<Integer> delete(@PathVariable("id") long id);
}
