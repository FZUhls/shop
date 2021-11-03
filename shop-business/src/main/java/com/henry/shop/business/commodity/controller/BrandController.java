package com.henry.shop.business.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.business.base.BaseController;
import com.henry.shop.business.commodity.vo.req.BrandReq;
import com.henry.shop.commodity.api.BrandRestService;
import com.henry.shop.commodity.dto.BrandDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Henry
 */
@Slf4j
@RestController
@Api(tags = "商品管理", value = "品牌管理")
public class BrandController extends BaseController {
    public static final String BASE_URI = "/brand";
    private static final String ADD = BASE_URI + "/addOne";
    private static final String GET_LIST = BASE_URI + "/getList";
    private static final String QUERY_BY_KEYWORD = BASE_URI + "/findByName";
    private static final String DELETE = BASE_URI + "/delete/{id}";
    private static final String UPDATE = BASE_URI + "/update";
    private static final String GET_ONE = BASE_URI + "/select/{id}";

    @Autowired
    private BrandRestService brandService;

    @GetMapping(GET_LIST)
    @ApiOperation(value = "分页查询品牌列表")
    public BaseResponse<Page<Brand>> getList(Integer pageNo, Integer size) {
        log.info("请求分页查询品牌列表====页号 {}页，页大小 {}条", pageNo, size);
        BaseResponse<Page<Brand>> response = brandService.getBrandList(pageNo, size);
        log.info("查询到的品牌列表 = {}", JSON.toJSONString(response));
        return response;
    }

    @GetMapping(QUERY_BY_KEYWORD)
    @ApiOperation(value = "根据关键字分页查询品牌列表")
    public BaseResponse<Page<Brand>> getListByName(Integer pageNo, Integer size, String keyword) {
        log.info("根据关键字请求分页查询品牌列表====页号 {}页，页大小 {}条,关键字为 {} ", pageNo, size, keyword);
        BaseResponse<Page<Brand>> response = brandService.findBrandByName(keyword, pageNo, size);
        log.info("查询到的品牌列表 = {}", JSON.toJSONString(response));
        return response;
    }

    @PostMapping(ADD)
    @ApiOperation(value = "添加一条品牌")
    public BaseResponse<Integer> add(BrandReq brandVo) {
        log.info("添加品牌，品牌内容为 {} ", JSON.toJSONString(brandVo));
        BrandDto brandDto = voMapToDto(brandVo);
        BaseResponse<Integer> response = brandService.addBrand(brandDto);
        return response;
    }

    @GetMapping(GET_ONE)
    @ApiOperation(value = "根据id查询品牌")
    public BaseResponse<Brand> queryOne(@PathVariable long id) {
        log.info("根据主键查询品牌，id = {}", id);
        BaseResponse<Brand> response = brandService.findById(id);
        log.info("查询结果为{}", JSON.toJSONString(response));
        return response;
    }
    @ApiOperation(value = "根据主键删除品牌")
    @PostMapping(DELETE)
    public BaseResponse<Integer> deleteById(@PathVariable long id){
        log.info("根据主键删除品牌，id = {}",id);
        BaseResponse<Integer> response = brandService.delete(id);
        log.info("共删除{}行数据",response.getData());
        return response;
    }
    @ApiOperation(value = "根据主键更新品牌")
    @PostMapping(UPDATE)
    public BaseResponse update(long id , BrandReq brandVo){
        log.info("根据主键修改品牌，id = {} ，修改内容 = {}",id,JSON.toJSONString(brandVo));
        BrandDto brandDto = voMapToDto(brandVo);
        BaseResponse<Integer> response = brandService.update(id, brandDto);
        log.info("{}行数据被修改",response.getData());
        return response;
    }

    private BrandDto voMapToDto(BrandReq brandVo) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandName(brandVo.getBrandName());
        brandDto.setBrandCode(brandVo.getBrandCode());
        return brandDto;
    }
}
