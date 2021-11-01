package com.henry.shop.business.commodity.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.business.commodity.vo.req.ParamAddReq;
import com.henry.shop.business.commodity.vo.req.ParamEditReq;
import com.henry.shop.business.commodity.vo.req.ParamGroupAddReq;
import com.henry.shop.business.commodity.vo.req.ParamGroupEditReq;
import com.henry.shop.commodity.api.ParamService;
import com.henry.shop.commodity.dto.ParamDto;
import com.henry.shop.commodity.dto.ParamGroupDto;
import com.henry.shop.common.base.enumerate.ParamType;
import com.henry.shop.common.base.exception.DataBaseNotFoundException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Henry
 * 商品参数controller类
 */
@Slf4j
@Api(value = "参数管理",tags = "商品管理")
@RestController(ParamController.BASE_URI)
public class ParamController {
    public static final String BASE_URI = "/param";
    private static final String ADD_GROUP = "/add-group";
    private static final String UPDATE_GROUP = "/update-group/{id}";
    private static final String DELETE_GROUP = "/delete-group/{id}";
    private static final String SELECT_GROUP = "/groups";
    private static final String ADD_PARAM = "/add-param";
    private static final String UPDATE_PARAM = "/update-param/{id}";
    private static final String DELETE_PARAM = "/delete-param/{id}";
    private static final String SELETE_PARAM = "/params";

    private ParamService paramService;

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
    public BaseResponse updateParamGroup(ParamGroupEditReq req, @PathVariable long id) throws DataBaseNotFoundException {
        String name = req.getName();
        ParamGroupDto paramGroupDto = new ParamGroupDto();
        paramGroupDto.setId(id);
        paramGroupDto.setName(name);
        paramService.editParamGroup(paramGroupDto);
        return BaseResponse.succ();
    }
    @DeleteMapping(DELETE_GROUP)
    @ApiOperation(value = "删除参数组")
    public BaseResponse deleteParamGroup(@PathVariable long id) throws DataBaseNotFoundException {
        paramService.deleteParamGroup(id);
        return BaseResponse.succ();
    }
    @GetMapping(SELECT_GROUP)
    @ApiOperation("查询参数组")
    @ApiImplicitParam(name = "page",value = "页码",example = "1")
    public BaseResponse selectParamGroup(int page){
        int size = 10;
        IPage<ComParamGroup> paramGroups = paramService.getParamGroups(page, size);
        BaseResponse succ = BaseResponse.succ();
        succ.setData(paramGroups);
        return succ;
    }
    @PostMapping(ADD_PARAM)
    @ApiOperation("添加参数项")
    public BaseResponse addParam(ParamAddReq req) throws DataBaseNotFoundException {
        ParamDto paramDto = new ParamDto();
        paramDto.setParamGroupId(req.getGroupId());
        paramDto.setName(req.getName());
        paramDto.setType(ParamType.getByCode(req.getType()));
        paramDto.setSelectValue(req.getSelectValues());
        paramDto.setSort(req.getSort());
        paramService.addParamToGroup(paramDto);
        return BaseResponse.succ();
    }
    @PutMapping(UPDATE_PARAM)
    @ApiOperation("修改参数项")
    @ApiImplicitParam(name = "id",value = "参数id")
    public BaseResponse updateParam(ParamEditReq req, @PathVariable long id) throws DataBaseNotFoundException {
        ParamDto paramDto = new ParamDto();
        paramDto.setName(req.getName());
        paramDto.setType(ParamType.getByCode(req.getType()));
        paramDto.setSelectValue(req.getSelectValues());
        paramDto.setSort(req.getSort());
        paramService.editParam(paramDto,id);
        return BaseResponse.succ();
    }
    @DeleteMapping(DELETE_PARAM)
    @ApiOperation("删除参数项")
    @ApiImplicitParam(name = "id",value = "参数id")
    public BaseResponse deleteParam(@PathVariable long id) throws DataBaseNotFoundException {
        paramService.deleteParam(id);
        return BaseResponse.succ();
    }
    @GetMapping(SELETE_PARAM)
    @ApiOperation("获取参数组中参数项")
    @ApiImplicitParam(name = "groupId",value = "参数组id",example = "1")
    public BaseResponse getParams(@RequestParam(name = "groupId") long groupId){
        List<ComParam> params = paramService.getParams(groupId);
        BaseResponse succ = BaseResponse.succ();
        succ.setData(params);
        return succ;
    }
}
