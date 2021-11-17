package com.henry.shop.commodity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.ParamIllegalException;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;

import java.util.List;
import java.util.Set;

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
    void deleteParamGroup(Long id) throws DataNotFoundException;

    /**
     * 修改参数组
     * @param paramGroupDto
     */
    void editParamGroup(ParamGroupDto paramGroupDto) throws DataNotFoundException;


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

    ComParam selectParamById(long id) throws DataNotFoundException;
    /**
     * 添加参数到参数组
     * @param paramDto
     */
    void addParamToGroup(ParamDto paramDto) throws DataNotFoundException;

    /**
     * 修改参数组
     * @param paramDto
     * @throws DataNotFoundException
     */
    void editParam(ParamDto paramDto,long id) throws DataNotFoundException;

    /**
     * @param id
     * @throws DataNotFoundException
     */
    void deleteParam(long id) throws DataNotFoundException;

    /**
     * @param param 参数对象
     * @param value 参数内容
     * @throws ParamIllegalException 当参数内容不符合规定的值时抛出异常
     */
    default void checkParamLegal(ComParam param,String value)throws ParamIllegalException {
        String[] selectValues = param.getSelectValue().split(",");
        Set<String> selectValuesSet = Set.of(selectValues);
        if(!selectValuesSet.contains(value)){
            throw new ParamIllegalException("参数值不是可选值");
        }
    }
}
