package com.henry.shop.commodity.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.commodity.dto.ParamDto;
import com.henry.shop.commodity.dto.ParamGroupDto;
import com.henry.shop.common.base.exception.DataBaseNotFoundException;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Henry
 */
@Component
@FeignClient(value = "commodity-center")
public interface ParamRestService {
    /**
     * 创建新的参数组
     * @param paramGroupDto
     */
    void createParamGroup(ParamGroupDto paramGroupDto);
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
    IPage<ComParamGroup> getParamGroups(long page, long size);


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
