package com.henry.shop.business.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.business.commodity.vo.req.ParamAddReq;
import com.henry.shop.business.commodity.vo.req.ParamEditReq;
import com.henry.shop.business.commodity.vo.req.ParamGroupAddReq;
import com.henry.shop.business.commodity.vo.req.ParamGroupEditReq;
import com.henry.shop.commodity.api.ParamRestService;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Henry
 * 商品参数controller类
 */
@Slf4j
@Api(value = "参数管理",tags = "商品管理--参数")
@RestController
public class ParamController {
    private static final String BASE_URI = "/param";
    private static final String ADD_GROUP = BASE_URI + "/add-group";
    private static final String UPDATE_GROUP = BASE_URI + "/update-group/{id}";
    private static final String DELETE_GROUP = BASE_URI + "/delete-group/{id}";
    private static final String SELECT_GROUP = BASE_URI + "/groups";
    private static final String ADD_PARAM = BASE_URI + "/add-param";
    private static final String UPDATE_PARAM = BASE_URI + "/update-param/{id}";
    private static final String DELETE_PARAM = BASE_URI + "/delete-param/{id}";
    private static final String SELETE_PARAM = BASE_URI + "/params";
    private static final int BASE_PAGE_SIZE = 10;
    @Autowired
    private ParamRestService paramService;

    @PostMapping(ADD_GROUP)
    @ApiOperation("添加参数组")
    public BaseResponse addParamGroup(ParamGroupAddReq req){
        log.info("请求添加参数组，参数 = {}", JSON.toJSONString(req));
        String name = req.getName();
        ParamGroupDto paramGroupDto = new ParamGroupDto();
        paramGroupDto.setName(name);
        paramService.createParamGroup(paramGroupDto);
        return BaseResponse.succ();
    }
    @PutMapping(UPDATE_GROUP)
    @ApiOperation(value = "更新参数组")
    public BaseResponse updateParamGroup(ParamGroupEditReq req, @PathVariable long id){
        String name = req.getName();
        ParamGroupDto paramGroupDto = new ParamGroupDto();
        paramGroupDto.setId(id);
        paramGroupDto.setName(name);
        return paramService.editParamGroup(id,paramGroupDto);
    }
    @DeleteMapping(DELETE_GROUP)
    @ApiOperation(value = "删除参数组")
    public BaseResponse deleteParamGroup(@PathVariable long id){
        paramService.deleteParamGroup(id);
        return BaseResponse.succ();
    }
    @GetMapping(SELECT_GROUP)
    @ApiOperation("查询参数组")
    @ApiImplicitParam(name = "page",value = "页码",example = "1")
    public BaseResponse<Page<ComParamGroup>> selectParamGroup(int page){
        int size = BASE_PAGE_SIZE;
        return paramService.getParamGroups(page, size);
    }
    @PostMapping(ADD_PARAM)
    @ApiOperation("添加参数项")
    public BaseResponse addParam(ParamAddReq req){
        ParamDto paramDto = new ParamDto();
        paramDto.setParamGroupId(req.getGroupId());
        paramDto.setName(req.getName());
        paramDto.setType(req.getType());
        paramDto.setSelectValue(req.getSelectValues());
        paramDto.setSort(req.getSort());
        return paramService.addParamToGroup(paramDto);
    }
    @PutMapping(UPDATE_PARAM)
    @ApiOperation("修改参数项")
    @ApiImplicitParam(name = "id",value = "参数id")
    public BaseResponse updateParam(ParamEditReq req, @PathVariable long id){
        ParamDto paramDto = new ParamDto();
        paramDto.setName(req.getName());
        paramDto.setType(req.getType());
        paramDto.setSelectValue(req.getSelectValues());
        paramDto.setSort(req.getSort());
        return paramService.editParam(paramDto,id);
    }
    @DeleteMapping(DELETE_PARAM)
    @ApiOperation("删除参数项")
    @ApiImplicitParam(name = "id",value = "参数id")
    public BaseResponse deleteParam(@PathVariable long id){
        return paramService.deleteParam(id);
    }
    @GetMapping(SELETE_PARAM)
    @ApiOperation("获取参数组中参数项")
    @ApiImplicitParam(name = "groupId",value = "参数组id",example = "1")
    public BaseResponse<List<ComParam>> getParams(@RequestParam(name = "groupId") long groupId){
        return paramService.getParams(groupId);
    }
}
