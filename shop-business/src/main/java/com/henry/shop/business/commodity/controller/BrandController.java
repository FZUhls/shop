package com.henry.shop.business.commodity.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.business.base.BaseController;
import com.henry.shop.business.commodity.vo.req.BrandList;
import com.henry.shop.business.commodity.vo.req.BrandReq;
import com.henry.shop.business.commodity.vo.res.BrandPageResponse;
import com.henry.shop.business.commodity.vo.res.BrandResponse;
import com.henry.shop.commodity.api.BrandService;
import com.henry.shop.commodity.dto.BrandDto;
import com.henry.shop.common.base.enumerate.Code;
import com.henry.shop.common.base.exception.BaseException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henry
 */
@Slf4j
@RestController(BrandController.BASE_URI)
@Api(tags = "商品管理", value = "品牌管理")
public class BrandController extends BaseController {
    public static final String BASE_URI = "/brand";
    private static final String ADD = "/addOne";
    private static final String ADD_BRANCH = "/addBranch";
    private static final String GET_LIST = "/getList";
    private static final String QUERY_BY_KEYWORD = "/findByName";
    private static final String DELETE = "/delete/{id}";
    private static final String UPDATE = "/update";
    private static final String GET_ONE = "/select/{id}";


    private BrandService brandService;

    @GetMapping(GET_LIST)
    @ApiOperation(value = "分页查询品牌列表")
    public BrandPageResponse getList(Integer pageNo, Integer size) {
        log.info("请求分页查询品牌列表====页号 {}页，页大小 {}条", pageNo, size);
        IPage<Brand> brandList = brandService.getBrandList(pageNo, size);
        BrandPageResponse response = new BrandPageResponse();
        response.setCode(Code.SUCCESS);
        response.setMsg("查询品牌成功");
        response.setBrandPage(brandList);
        log.info("查询到的品牌列表 = {}", JSON.toJSONString(brandList));
        return response;
    }

    @GetMapping(QUERY_BY_KEYWORD)
    @ApiOperation(value = "根据关键字分页查询品牌列表")
    public BrandPageResponse getListByName(Integer pageNo, Integer size, String keyword) {
        log.info("根据关键字请求分页查询品牌列表====页号 {}页，页大小 {}条,关键字为 {} ", pageNo, size, keyword);
        IPage<Brand> brandList = brandService.findBrandByName(keyword, pageNo, size);
        BrandPageResponse response = new BrandPageResponse();
        response.setCode(Code.SUCCESS);
        response.setMsg("查询品牌成功");
        response.setBrandPage(brandList);
        log.info("查询到的品牌列表 = {}", JSON.toJSONString(brandList));
        return response;
    }

    @PostMapping(ADD)
    @ApiOperation(value = "添加一条品牌")
    public BaseResponse add(BrandReq brandVo) {
        log.info("添加品牌，品牌内容为 {} ", JSON.toJSONString(brandVo));
        BrandDto brandDto = voMapToDto(brandVo);
        int num = brandService.addBrand(brandDto);
        log.info("新插入的行数为 {}", num);
        BaseResponse response = new BaseResponse();
        response.setCode(Code.SUCCESS);
        response.setMsg(StrUtil.format("成功添加{}条品牌信息", num));
        return response;
    }

    @ApiOperation(value = "批量添加品牌")
    @PostMapping(ADD_BRANCH)
    public BaseResponse addBranch(BrandList brandList) {
        log.info("批量添加品牌，品牌列表内容为 {} ", JSON.toJSONString(brandList));
        List<BrandDto> brandDtoList = brandList.getBrandVoList().stream().map(this::voMapToDto).collect(Collectors.toList());
        int num = brandService.addBrandBranch(brandDtoList);
        log.info("新插入的行数为 {}", num);
        BaseResponse response = new BaseResponse();
        response.setCode(Code.SUCCESS);
        response.setMsg(StrUtil.format("成功添加{}条品牌信息", num));
        return response;
    }
    @GetMapping(GET_ONE)
    @ApiOperation(value = "查询单条品牌")
    public BrandResponse queryOne(@PathVariable long id) {
        log.info("根据主键查询品牌，id = {}", id);
        Brand brand = brandService.findById(id);
        log.info("查询结果为{}", JSON.toJSONString(brand));
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setCode(Code.SUCCESS);
        brandResponse.setMsg("查询成功");
        brandResponse.setBrand(brand);
        return brandResponse;
    }
    @ApiOperation(value = "根据主键删除品牌")
    @PostMapping(DELETE)
    public BaseResponse deleteById(@PathVariable long id){
        log.info("根据主键删除品牌，id = {}",id);
        try {
            int num = brandService.delete(id);
            log.info("共删除{}行数据",num);
            return BaseResponse.succ();
        } catch (BaseException e) {
            log.info("删除品牌发生异常，异常原因{} , ",e.getMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getMessage());
            return response;
        }
    }
    @ApiOperation(value = "根据主键更新品牌")
    @PostMapping(UPDATE)
    public BaseResponse update(long id , BrandReq brandVo){
        log.info("根据主键修改品牌，id = {} ，修改内容 = {}",id,JSON.toJSONString(brandVo));
        BrandDto brandDto = voMapToDto(brandVo);
        try {
            int num = brandService.update(id, brandDto);
            log.info("{}行数据被修改",num);
            return BaseResponse.succ();
        } catch (BaseException e) {
            log.error("请求删除品牌出错,错误原因 = {} ，异常栈 = ",e.getMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getMessage());
            return response;
        }
    }

    private BrandDto voMapToDto(BrandReq brandVo) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandName(brandVo.getBrandName());
        brandDto.setBrandCode(brandVo.getBrandCode());
        return brandDto;
    }

}
