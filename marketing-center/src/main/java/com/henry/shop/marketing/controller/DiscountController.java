package com.henry.shop.marketing.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.marketing.dto.req.DiscountDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Discount;
import com.henry.shop.marketing.service.DiscountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wjh
 * date  2022/4/14
 */


@Slf4j
@RestController
@Api(tags = "折扣商品")
public class DiscountController {
    public static final String BASE_URL = "/marketing/discount";
    private static final String ADD = BASE_URL + "/add";
    private static final String SELECT_DISCOUNT_BY_NAME = BASE_URL + "/findByName";
    private static final String SELECT_BY_ID = BASE_URL + "/findById/{id}";
    private static final String UPDATE_BY_ID = BASE_URL + "/update/{id}";
    private static final String DELETE_BY_ID = BASE_URL + "/delete/{id}";

    @Autowired
    DiscountService discountService;

    @PostMapping(ADD)
    @ApiOperation(value = "添加折扣")
    public BaseResponse<Discount> add(@RequestBody DiscountDto discountDto){
        Discount discount = discountService.add(discountDto);
        BaseResponse response = BaseResponse.succ();
        response.setData(discount);
        return response;
    }

    @GetMapping(SELECT_DISCOUNT_BY_NAME)
    @ApiOperation(value = "关键字搜索")
    public BaseResponse<Page<Discount>> selectByName(@RequestParam("pageNo") long pageNo,
                                                     @RequestParam("size") long size, @RequestParam("keyword") String keyword){
        Page<Discount> discountPage = discountService.selectByPage(pageNo, size, keyword);
        BaseResponse response = BaseResponse.succ();
        response.setData(discountPage);
        return response;
    }

    @GetMapping(SELECT_BY_ID)
    @ApiOperation(value = "ID搜索")
    public BaseResponse<Discount> selectByName(@PathVariable("id") long id){
        Discount discount = discountService.selectById(id);
        BaseResponse response = BaseResponse.succ();
        response.setData(discount);
        return response;
    }

    @PutMapping(UPDATE_BY_ID)
    @ApiOperation("更新商品折扣")
    public BaseResponse<Discount> update(@PathVariable("id") long id, @RequestBody DiscountDto discountDto) throws DataNotFoundException {
        Discount discount = discountService.updateDiscount(id, discountDto);
        BaseResponse response = BaseResponse.succ();
        response.setData(discount);
        return response;
    }

    @DeleteMapping(DELETE_BY_ID)
    @ApiOperation("删除折扣商品")
    public BaseResponse delete(@PathVariable("id") long id) {
        try {
            discountService.deleteDiscount(id);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("删除折扣商品发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
}
