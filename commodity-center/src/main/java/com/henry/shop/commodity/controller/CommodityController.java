package com.henry.shop.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.CommodityUpdDto;
import com.henry.shop.commodity.dto.req.SkuUpdDto;
import com.henry.shop.commodity.dto.res.CommodityRes;
import com.henry.shop.commodity.dto.res.CommodityShortRes;
import com.henry.shop.commodity.dto.res.SkuRes;
import com.henry.shop.commodity.service.CommodityService;
import com.henry.shop.common.base.enumerate.Code;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.ParamIllegalException;
import com.henry.shop.common.base.form.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Henry
 */
@RestController
@Slf4j
public class CommodityController {

    private static final String BASE = "/commodity";
    private static final String CREATE = BASE + "/create";
    private static final String UPDATE_COMMODITY = BASE + "/update-commodity/{id}";
    private static final String UPDATE_SKU_LIST = BASE + "update-skuList";
    private static final String UPDATE_COMMODITY_STATUS = BASE + "update/comStatus/{id}";
    private static final String DELETE = BASE + "/delete/{id}";
    private static final String SELETE = BASE + "/select/{id}";
    private static final String SEARCH_COMMODITY_BY_KEYWORD = BASE + "search-commodity";
    private static final String SELECT_SKUS = BASE + "select-skus/{commodityId}";

    @Autowired
    private CommodityService commodityService;

    @GetMapping(SELETE)
    public BaseResponse<CommodityRes> selectOne(@PathVariable("id") long id){
        try {
            CommodityRes commodityRes = commodityService.selectById(id);
            BaseResponse<CommodityRes> response = BaseResponse.succ();
            response.setData(commodityRes);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id查询商品发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PostMapping(CREATE)
    public BaseResponse createCommodity(@RequestBody CommodityDto commodityDto){
        try {
            commodityService.createCommodity(commodityDto);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException | ParamIllegalException e) {
            log.error("创建商品发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @DeleteMapping(DELETE)
    public BaseResponse deleteCommodity(@PathVariable("id") long id){
        try {
            commodityService.deleteCommodity(id);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("删除商品发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_COMMODITY_STATUS)
    public BaseResponse updateCommodityStatus(@PathVariable("id") long id, PublishStatus publishStatus){
        try {
            commodityService.updateCommodityPublishStatus(id,publishStatus);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("修改商品状态发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_COMMODITY)
    public BaseResponse updateCommodity(@PathVariable("id") long id, @RequestBody CommodityUpdDto commodityUpdDto){
        try {
            commodityService.updateCommodity(id,commodityUpdDto);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("更新商品发生异常，异常原因 : {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_SKU_LIST)
    public BaseResponse updateSkuList(@RequestBody SkuUpdDto skuUpdDto){
        commodityService.updateSku(skuUpdDto);
        BaseResponse response = BaseResponse.succ();
        return response;
    }

    @GetMapping(SEARCH_COMMODITY_BY_KEYWORD)
    public BaseResponse<Page<CommodityShortRes>> searchCommodity(int pageNo,int size,String keyword){
        Page<CommodityShortRes> commodityShortResPage = commodityService.getCommoditys(pageNo, size, keyword);
        BaseResponse succ = BaseResponse.succ();
        succ.setData(commodityShortResPage);
        return succ;
    }

    @GetMapping(SELECT_SKUS)
    public BaseResponse<List<SkuRes>> selectSkuByCommodityId(@PathVariable("commodityId") long id){
        BaseResponse<List<SkuRes>> response = new BaseResponse<>();
        try {
            response.setCode(Code.SUCCESS);
            response.setMsg("查询成功");
            List<SkuRes> skuRes = commodityService.selectSkusByCommodityId(id);
            response.setData(skuRes);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据商品id查询商品sku列表时发生异常...",e);
            response.setCode(Code.FAIL);
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }

}
