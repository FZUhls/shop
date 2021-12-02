package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.CommodityUpdDto;
import com.henry.shop.commodity.dto.req.SkuUpdDto;
import com.henry.shop.commodity.dto.res.CommodityRes;
import com.henry.shop.commodity.dto.res.CommodityShortRes;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.form.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 商品service类
 * @author Henry
 */
@FeignClient(value = "commodity-center")
public interface CommodityRestService {
    String BASE = "/commodity";
    String CREATE = BASE + "/create";
    String UPDATE_COMMODITY = BASE + "/update-commodity/{id}";
    String UPDATE_SKU_LIST = BASE + "update-skuList";
    String UPDATE_COMMODITY_STATUS = BASE + "update/comStatus/{id}";
    String DELETE = BASE + "/delete/{id}";
    String SELETE = BASE + "/select/{id}";
    String SEARCH_COMMODITY_BY_KEYWORD = BASE + "search-commodity";

    @GetMapping(SELETE)
    BaseResponse<CommodityRes> selectOne(@PathVariable("id") long id);

    @PostMapping(CREATE)
    BaseResponse createCommodity(@RequestBody CommodityDto commodityDto);

    @DeleteMapping(DELETE)
    BaseResponse deleteCommodity(@PathVariable("id") long id);

    @PutMapping(UPDATE_COMMODITY_STATUS)
    BaseResponse updateCommodityStatus(@PathVariable("id") long id, PublishStatus publishStatus);

    @PutMapping(UPDATE_COMMODITY)
    BaseResponse updateCommodity(@PathVariable("id") long id, @RequestBody CommodityUpdDto commodityUpdDto);

    @PutMapping(UPDATE_SKU_LIST)
    BaseResponse updateSkuList(@RequestBody SkuUpdDto skuUpdDto);

    @GetMapping(SEARCH_COMMODITY_BY_KEYWORD)
    BaseResponse<Page<CommodityShortRes>> searchCommodity(@RequestParam("pageNo") int pageNo, @RequestParam("size") int size, @RequestParam("keyword") String keyword);
}
