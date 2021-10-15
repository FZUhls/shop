package com.henry.shop.commodity.api;

import com.henry.shop.commodity.dto.ParamDto;
import com.henry.shop.commodity.dto.ParamGroupDto;

/**
 * @author Henry
 */
public interface ParamService {
    /**
     * 创建新的参数组
     * @param paramGroupDto
     */
    void createParamGroup(ParamGroupDto paramGroupDto);

    /**
     * 添加参数到参数组
     * @param paramDto
     */
    void addParamToGroup(ParamDto paramDto);

    /**
     * 删除参数组
     * @param id
     */
    void deleteParamGroup(Long id);

    /**
     * 修改参数组
     * @param paramGroupDto
     */
    void editParamGroup(ParamGroupDto paramGroupDto);
}
