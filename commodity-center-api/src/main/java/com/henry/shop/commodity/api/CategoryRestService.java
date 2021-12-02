package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CategoryDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry
 */
@FeignClient("commodity-center")
public interface CategoryRestService {
    String BASE_URL = "/category";
    String CREATE = BASE_URL + "/create";
    String UPDATE = BASE_URL + "/update/{id}";
    String DELETE = BASE_URL + "/delete/{id}";
    String SELECT_BY_ID = BASE_URL + "/select/{id}";
    String SELECT_BY_PAGE = BASE_URL + "/select-pages";
    String SELECT_BY_NAME = BASE_URL + "/select-name";

    @GetMapping(SELECT_BY_ID)
    BaseResponse<Category> selectById(@PathVariable("id") long id);

    @GetMapping(SELECT_BY_PAGE)
    BaseResponse<Page<Category>> selectByPages(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size);

    @GetMapping(SELECT_BY_NAME)
    BaseResponse<Page<Category>> selectByName(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size, @RequestParam("keyword") String keyword);

    @PostMapping(CREATE)
    BaseResponse<Category> create(@RequestBody CategoryDto categoryDto);

    @PutMapping(UPDATE)
    BaseResponse<Category> update(@PathVariable("id") long id, @RequestBody CategoryDto categoryDto);

    @DeleteMapping(DELETE)
    BaseResponse delete(@PathVariable("id") long id);
}
