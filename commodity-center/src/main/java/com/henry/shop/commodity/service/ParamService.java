package com.henry.shop.commodity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.common.base.exception.DataBaseNotFoundException;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;

import java.util.List;

/**
 * @author Henry
 */
public interface ParamService {
    /**
     * 创建新的参数组
     * @param paramGroupDto
     */
    int createParamGroup(ParamGroupDto paramGroupDto);
    /**
     * 删除参数组
     * @param id
     */
    void deleteParamGroup(Long id) throws DataBaseNotFoundException;

    /**
     * 修改参数组
     * @param paramGroupDto
     */
    void editParamGroup(ParamGroupDto paramGroupDto) throws DataBaseNotFoundException;


    /**
     * @param page 页码
     * @param size 页大小
     * @return
     */
    Page<ComParamGroup> getParamGroups(long page, long size);


    /**
     * @param groupId 参数组id
     * @return 参数组内的所有参数
     */
    List<ComParam> getParams(long groupId);
    /**
     * 添加参数到参数组
     * @param paramDto
     */
    void addParamToGroup(ParamDto paramDto) throws DataBaseNotFoundException;

    /**
     * 修改参数组
     * @param paramDto
     * @throws DataBaseNotFoundException
     */
    void editParam(ParamDto paramDto,long id) throws DataBaseNotFoundException;

    /**
     * @param id
     * @throws DataBaseNotFoundException
     */
    void deleteParam(long id) throws DataBaseNotFoundException;

}
