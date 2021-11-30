package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Henry
 */
@FeignClient(value = "commodity-center")
public interface ParamRestService {
    String BASE_URL = "/commodity/param";
    String CREATE_PARAM_GROUP = BASE_URL + "/createParamGroup";
    String CREATE_PARAM = BASE_URL + "/createParam";
    String UPDATE_PARAM_GROUP = BASE_URL + "/updateParamGroup/{id}";
    String UPDATE_PARAM = BASE_URL + "/updateParam/{id}";
    String DELETE_PARAM_GROUP = BASE_URL + "/deleteParamGroup{id}";
    String DELETE_PARAM = BASE_URL + "/deleteParam/{id}";
    String SELETE_PARAM_GROUPS = BASE_URL + "/selectParamGroups";
    String SELETE_PARAMS = BASE_URL + "/selectParams/{groupId}";
    /**
     * 创建新的参数组
     * @param paramGroupDto
     */
    @PostMapping(CREATE_PARAM_GROUP)
    BaseResponse createParamGroup(@RequestBody ParamGroupDto paramGroupDto);
    /**
     * 删除参数组
     * @param id
     */
    @DeleteMapping(DELETE_PARAM_GROUP)
    BaseResponse deleteParamGroup(@PathVariable("id") Long id);


    /**
     * @param id
     * @param paramGroupDto
     * @return
     * @throws DataNotFoundException
     */
    @PutMapping(UPDATE_PARAM_GROUP)
    BaseResponse editParamGroup(@PathVariable("id") long id,@RequestBody ParamGroupDto paramGroupDto);


    /**
     * @param page 页码
     * @param size 页大小
     * @return
     */
    @GetMapping(SELETE_PARAM_GROUPS)
    BaseResponse<Page<ComParamGroup>> getParamGroups(@RequestParam("page") long page, @RequestParam("size") long size);


    /**
     * @param groupId 参数组id
     * @return 参数组内的所有参数
     */
    @GetMapping(SELETE_PARAMS)
    BaseResponse<List<ComParam>> getParams(@PathVariable("groupId") long groupId);
    /**
     * 添加参数到参数组
     * @param paramDto
     */
    @PostMapping(CREATE_PARAM)
    BaseResponse addParamToGroup(@RequestBody ParamDto paramDto);

    /**
     * 修改参数组
     * @param paramDto
     * @throws DataNotFoundException
     */
    @PutMapping(UPDATE_PARAM)
    BaseResponse editParam(@RequestBody ParamDto paramDto,@PathVariable("id") long id);

    /**
     * @param id
     * @throws DataNotFoundException
     */
    @DeleteMapping(DELETE_PARAM)
    BaseResponse deleteParam(@PathVariable("id") long id);

}
