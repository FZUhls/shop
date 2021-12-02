package com.henry.shop.business.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.api.CategoryRestService;
import com.henry.shop.commodity.dto.req.CategoryDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry
 */
@RestController
@Slf4j
@Api(value = "商品管理",tags = "商品管理--类别")
public class CategoryController {
    private static final String BASE_URL = "/category";
    private static final String CREATE = BASE_URL + "/create";
    private static final String UPDATE = BASE_URL + "/update/{id}";
    private static final String DELETE = BASE_URL + "/delete/{id}";
    private static final String SELECT_BY_ID = BASE_URL + "/select/{id}";
    private static final String SELECT_BY_PAGE = BASE_URL + "/select-pages";
    private static final String SELECT_BY_NAME = BASE_URL + "/select-name";

    @Autowired
    CategoryRestService categoryRestService;

    @GetMapping(SELECT_BY_ID)
    @ApiOperation("根据id查询类别")
    public BaseResponse<Category> selectById(@PathVariable("id") long id){
        return categoryRestService.selectById(id);
    }
    @GetMapping(SELECT_BY_PAGE)
    @ApiOperation("分页查询类别")
    public BaseResponse<Page<Category>> selectByPages(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size){
        return categoryRestService.selectByPages(pageNo, size);
    }
    @GetMapping(SELECT_BY_NAME)
    @ApiOperation("按关键字分页查询类别")
    public BaseResponse<Page<Category>> selectByName(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size, @RequestParam("keyword") String keyword){
        return categoryRestService.selectByName(pageNo, size, keyword);
    }
    @PostMapping(CREATE)
    @ApiOperation("创建类别")
    public BaseResponse<Category> create(@RequestBody CategoryDto categoryDto){
        return categoryRestService.create(categoryDto);
    }
    @PutMapping(UPDATE)
    @ApiOperation("更新类别")
    public BaseResponse<Category> update(@PathVariable("id") long id, @RequestBody CategoryDto categoryDto){
        return categoryRestService.update(id, categoryDto);
    }
    @DeleteMapping(DELETE)
    @ApiOperation("删除类别")
    public BaseResponse delete(@PathVariable("id") long id){
        return categoryRestService.delete(id);
    }
}
