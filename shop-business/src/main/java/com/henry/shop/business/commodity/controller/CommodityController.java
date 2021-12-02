package com.henry.shop.business.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.api.CommodityRestService;
import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.CommodityUpdDto;
import com.henry.shop.commodity.dto.req.SkuUpdDto;
import com.henry.shop.commodity.dto.res.CommodityRes;
import com.henry.shop.commodity.dto.res.CommodityShortRes;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.form.BaseResponse;
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
@Api(value = "商品管理",tags = "商品管理--商品")
public class CommodityController {
    private static final String BASE = "/commodity";
    private static final String CREATE = BASE + "/create";
    private static final String UPDATE_COMMODITY = BASE + "/update-commodity/{id}";
    private static final String UPDATE_SKU_LIST = BASE + "update-skuList";
    private static final String UPDATE_COMMODITY_STATUS = BASE + "update/comStatus/{id}";
    private static final String DELETE = BASE + "/delete/{id}";
    private static final String SELETE = BASE + "/select/{id}";
    private static final String SEARCH_COMMODITY_BY_KEYWORD = BASE + "search-commodity";

    @Autowired
    CommodityRestService commodityRestService;

    @GetMapping(SELETE)
    @ApiOperation("根据id查询商品")
    public BaseResponse<CommodityRes> selectOne(@PathVariable("id") long id){
        return commodityRestService.selectOne(id);
    }
    @PostMapping(CREATE)
    @ApiOperation("创建商品")
    public BaseResponse createCommodity(@RequestBody CommodityDto commodityDto){
        return commodityRestService.createCommodity(commodityDto);
    }
    @DeleteMapping(DELETE)
    @ApiOperation("根据id删除商品")
    public BaseResponse deleteCommodity(@PathVariable("id") long id){
        return commodityRestService.deleteCommodity(id);
    }
    @PutMapping(UPDATE_COMMODITY_STATUS)
    @ApiOperation("更新商品状态")
    public BaseResponse updateCommodityStatus(@PathVariable("id") long id, PublishStatus publishStatus){
        return commodityRestService.updateCommodityStatus(id,publishStatus);
    }
    @PutMapping(UPDATE_COMMODITY)
    @ApiOperation("更新商品")
    public BaseResponse updateCommodity(@PathVariable("id") long id, @RequestBody CommodityUpdDto commodityUpdDto){
        return commodityRestService.updateCommodity(id,commodityUpdDto);
    }
    @PutMapping(UPDATE_SKU_LIST)
    @ApiOperation("更新商品sku")
    public BaseResponse updateSkuList(@RequestBody SkuUpdDto skuUpdDto){
        return commodityRestService.updateSkuList(skuUpdDto);
    }

    @GetMapping(SEARCH_COMMODITY_BY_KEYWORD)
    @ApiOperation("按关键字搜索商品")
    public BaseResponse<Page<CommodityShortRes>> searchCommodity(int pageNo, int size, String keyword){
        return commodityRestService.searchCommodity(pageNo,size,keyword);
    }
}
