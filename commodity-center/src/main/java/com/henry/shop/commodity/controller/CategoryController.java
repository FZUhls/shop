package com.henry.shop.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CategoryDto;
import com.henry.shop.commodity.service.CategoryService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "商品类别管理")
@Slf4j
public class CategoryController {
    private static final String BASE_URL = "/category";
    private static final String CREATE = BASE_URL + "/create";
    private static final String UPDATE = BASE_URL + "/update/{id}";
    private static final String DELETE = BASE_URL + "/delete/{id}";
    private static final String SELECT_BY_ID = BASE_URL + "/select/{id}";
    private static final String SELECT_BY_PAGE = BASE_URL + "/select-pages";
    private static final String SELECT_BY_NAME = BASE_URL + "/select-name";

    @Autowired
    CategoryService categoryService;

    @GetMapping(SELECT_BY_ID)
    @ApiOperation("根据id查询商品类别")
    public BaseResponse<Category> selectById(@PathVariable("id") long id){
        Category category = categoryService.selectById(id);
        BaseResponse response = BaseResponse.succ();
        response.setData(category);
        return response;
    }
    @GetMapping(SELECT_BY_PAGE)
    @ApiOperation("分页查询类别")
    public BaseResponse<Page<Category>> selectByPages(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size){
        Page<Category> categoryPage = categoryService.selectByPage(pageNo, size);
        BaseResponse response = BaseResponse.succ();
        response.setData(categoryPage);
        return response;
    }
    @GetMapping(SELECT_BY_NAME)
    @ApiOperation("关键词分页查询类别")
    public BaseResponse<Page<Category>> selectByName(@RequestParam("pageNo") long pageNo, @RequestParam("size") long size, @RequestParam("keyword") String keyword){
        Page<Category> categoryPage = categoryService.selectByPage(pageNo, size, keyword);
        BaseResponse response = BaseResponse.succ();
        response.setData(categoryPage);
        return response;
    }
    @PostMapping(CREATE)
    @ApiOperation("创建商品类别")
    public BaseResponse<Category> create(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createCategory(categoryDto);
        BaseResponse response = BaseResponse.succ();
        response.setData(category);
        return response;
    }
    @PutMapping(UPDATE)
    @ApiOperation("更新商品类别")
    public BaseResponse<Category> update(@PathVariable("id") long id, @RequestBody CategoryDto categoryDto){
        try {
            Category category = categoryService.updateCategory(id, categoryDto);
            BaseResponse response = BaseResponse.succ();
            response.setData(category);
            return response;
        } catch (DataNotFoundException e) {
            log.error("更新类别时发生异常，异常原因 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @DeleteMapping(DELETE)
    @ApiOperation("删除商品类别")
    public BaseResponse delete(@PathVariable("id") long id){
        try {
            categoryService.deleteById(id);
            return BaseResponse.succ();
        } catch (DataNotFoundException e) {
            log.error("删除类别时发生异常，异常原因 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
}
