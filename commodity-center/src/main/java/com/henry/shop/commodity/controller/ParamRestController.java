package com.henry.shop.commodity.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.commodity.service.ParamService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author henry1
 */
@Slf4j
@RestController
@Api(tags = "商品参数管理")
public class ParamRestController {
    private static final String BASE_URL = "/commodity/param";
    private static final String CREATE_PARAM_GROUP = BASE_URL + "/createParamGroup";
    private static final String CREATE_PARAM = BASE_URL + "/createParam";
    private static final String UPDATE_PARAM_GROUP = BASE_URL + "/updateParamGroup/{id}";
    private static final String UPDATE_PARAM = BASE_URL + "/updateParam/{id}";
    private static final String DELETE_PARAM_GROUP = BASE_URL + "/deleteParamGroup{id}";
    private static final String DELETE_PARAM = BASE_URL + "/deleteParam/{id}";
    private static final String SELETE_PARAM_GROUPS = BASE_URL + "/selectParamGroups";
    private static final String SELETE_PARAMS = BASE_URL + "/selectParams/{groupId}";
    @Autowired
    ParamService paramService;
    @PostMapping(CREATE_PARAM_GROUP)
    @ApiOperation("创建参数组")
    public BaseResponse createParamGroup(@RequestBody ParamGroupDto paramGroupDto){
        int count = paramService.createParamGroup(paramGroupDto);
        BaseResponse succ = BaseResponse.succ();
        succ.setData(count);
        return succ;
    }
    @PostMapping(CREATE_PARAM)
    @ApiOperation("创建参数")
    public BaseResponse createParam(@RequestBody ParamDto paramDto){
        try {
            paramService.addParamToGroup(paramDto);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("添加参数发生异常，异常消息 = {}，异常栈 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_PARAM_GROUP)
    @ApiOperation("更新参数组")
    public BaseResponse updateParamGroup(@PathVariable("id") long id,@RequestBody ParamGroupDto paramGroupDto){
        try {
            paramService.editParamGroup(paramGroupDto);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("修改参数组发生异常，异常消息 = {}，异常栈 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @PutMapping(UPDATE_PARAM)
    @ApiOperation("更新参数")
    public BaseResponse updateParam(@PathVariable("id") long id,@RequestBody ParamDto paramDto){
        try {
            paramService.editParam(paramDto,id);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("修改参数发生异常，异常消息 = {}，异常栈 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @DeleteMapping(DELETE_PARAM_GROUP)
    @ApiOperation("删除参数组")
    public BaseResponse deleteParamGroup(@PathVariable("id") long id){
        try {
            paramService.deleteParamGroup(id);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("删除参数发生异常，异常消息 = {}，异常栈 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @DeleteMapping(DELETE_PARAM)
    @ApiOperation("删除参数")
    public BaseResponse deleteParam(@PathVariable("id") long id){
        try {
            paramService.deleteParam(id);
            BaseResponse response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("删除参数发生异常，异常消息 = {}，异常栈 = {}",e.getLocalizedMessage(),e);
            BaseResponse fail = BaseResponse.fail();
            fail.setMsg(e.getLocalizedMessage());
            return fail;
        }
    }
    @GetMapping(SELETE_PARAM_GROUPS)
    @ApiOperation("分页查询参数组")
    public BaseResponse<Page<ComParamGroup>> getParamGroups(long page, long size){
        Page<ComParamGroup> paramGroups = paramService.getParamGroups(page, size);
        BaseResponse<Page<ComParamGroup>> response = BaseResponse.succ();
        response.setData(paramGroups);
        return response;
    }
    @GetMapping(SELETE_PARAMS)
    @ApiOperation("根据id获取参数组内参数")
    public BaseResponse<List<ComParam>> getParams(@PathVariable("groupId") long groupId){
        List<ComParam> params = paramService.getParams(groupId);
        BaseResponse<List<ComParam>> response = BaseResponse.succ();
        response.setData(params);
        return response;
    }
}
