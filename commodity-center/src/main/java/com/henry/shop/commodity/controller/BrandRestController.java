package com.henry.shop.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.BrandDto;
import com.henry.shop.commodity.service.BrandService;
import com.henry.shop.common.base.enumerate.Code;
import com.henry.shop.common.base.exception.BaseException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author henry1
 */
@Slf4j
@RestController
public class BrandRestController {
    public static final String BASE_URL = "/commodity/brand";
    private static final String ADD_BRAND = BASE_URL + "/add-brand";
    private static final String SELECT_BRAND = BASE_URL + "/find-brands";
    private static final String SELECT_BRAND_BY_NAME = BASE_URL + "/findByName";
    private static final String SELECT_BY_ID = BASE_URL + "/findById/{id}";
    private static final String UPDATE_BY_ID = BASE_URL + "/update/{id}";
    private static final String DELETE_BY_ID = BASE_URL + "/delete/{id}";

    @Autowired
    BrandService brandService;

    @PostMapping(ADD_BRAND)
    public BaseResponse<Integer> addBrand(@RequestBody BrandDto brandVo){
        int count = brandService.addBrand(brandVo);
        BaseResponse<Integer> succ = BaseResponse.succ();
        succ.setData(count);
        return succ;
    }
    @GetMapping(SELECT_BRAND)
    public BaseResponse<Page<Brand>> selectBrands(long pageNo, long size){
        Page<Brand> brandList = brandService.getBrandList(pageNo, size);
        BaseResponse<Page<Brand>> succ = BaseResponse.succ();
        succ.setData(brandList);
        return succ;
    }
    @GetMapping(SELECT_BRAND_BY_NAME)
    public BaseResponse<Page<Brand>> selectBrands(long pageNo, long size, String name){
        Page<Brand> brandList = brandService.findBrandByName(name,pageNo,size);
        BaseResponse<Page<Brand>> succ = BaseResponse.succ();
        succ.setData(brandList);
        return succ;
    }
    @GetMapping(SELECT_BY_ID)
    public BaseResponse<Brand> findById(@PathVariable("id") long id){
        try {
            Brand brand = brandService.findById(id);
            BaseResponse<Brand> response = new BaseResponse<>();
            response.setCode(Code.SUCCESS);
            response.setData(brand);
            return response;
        }catch (Exception e){
            log.error("??????id??????????????????????????? ???????????? = {}???????????? = ",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_BY_ID)
    public BaseResponse<Integer> update(@PathVariable("id") long id,@RequestBody BrandDto brandDto){
        try {
            int count = brandService.update(id, brandDto);
            BaseResponse<Integer> response = BaseResponse.succ();
            response.setData(count);
            return response;
        } catch (BaseException e) {
            log.error("??????id??????????????????????????????????????? = {}???????????? = ",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @DeleteMapping(DELETE_BY_ID)
    public BaseResponse delete(@PathVariable("id") long id){
        try {
            int delete = brandService.delete(id);
            BaseResponse succ = BaseResponse.succ();
            succ.setData(delete);
            return succ;
        } catch (BaseException e) {
            log.error("??????id??????????????????????????????????????? = {}???????????? = ",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
}
