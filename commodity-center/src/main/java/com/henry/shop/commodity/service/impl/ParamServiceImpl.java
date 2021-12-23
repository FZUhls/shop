package com.henry.shop.commodity.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.ParamDto;
import com.henry.shop.commodity.dto.req.ParamGroupDto;
import com.henry.shop.commodity.service.ParamService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.mapper.com.ComParamGroupMapper;
import com.henry.shop.common.base.mapper.com.ComParamMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParam;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Henry
 */
@Service
@Slf4j
public class ParamServiceImpl implements ParamService {

    @Autowired
    ComParamGroupMapper comParamGroupMapper;
    @Autowired
    ComParamMapper comParamMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int createParamGroup(ParamGroupDto paramGroupDto) {
        log.info("创建新的商品参数组，参数组内容为 = {}", JSON.toJSONString(paramGroupDto));
        String paramGroupName = paramGroupDto.getName();
        Date date = new Date();
        ComParamGroup comParamGroup = new ComParamGroup();
        comParamGroup.setName(paramGroupName);
        comParamGroup.setNum(0);
        comParamGroup.setCreTime(date);
        comParamGroup.setUpdTime(date);
        int count = comParamGroupMapper.insert(comParamGroup);
        log.info("插入新的参数组成功");
        return count;
    }

    private ComParam dtoToBo(ParamDto paramDto) {
        Date date = new Date();
        ComParam param = new ComParam();
        param.setParamGroupId(paramDto.getParamGroupId());
        param.setCreTime(date);
        param.setUpdTime(date);
        param.setName(paramDto.getName());
        param.setSelectValue(paramDto.getSelectValue());
        param.setType(paramDto.getType());
        param.setSort(paramDto.getSort());
        return param;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addParamToGroup(ParamDto paramDto) throws DataNotFoundException {
        Long paramGroupId = paramDto.getParamGroupId();
        ComParamGroup comParamGroup = comParamGroupMapper.selectById(paramGroupId);
        if (Objects.isNull(comParamGroup)) {
            log.error("参数组不存在");
            throw new DataNotFoundException();
        }
        ComParam param = dtoToBo(paramDto);
        if(param.getSort() == 0){
            param.setSort(comParamGroup.getNum() + 1);
        }
        comParamMapper.insert(param);
        comParamGroup.setNum(comParamGroup.getNum() + 1);
        comParamGroupMapper.updateById(comParamGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editParam(ParamDto paramDto,long id) throws DataNotFoundException {
        log.info("开始修改参数项,id = {} ，请求表单 = {}",id,JSON.toJSONString(paramDto));
        ComParam param = comParamMapper.selectById(id);
        if(Objects.isNull(param)){
            log.error("参数不存在");
            throw new DataNotFoundException();
        }
        param.setType(paramDto.getType());
        param.setName(paramDto.getName());
        param.setSort(paramDto.getSort());
        param.setSelectValue(paramDto.getSelectValue());
        param.setUpdTime(new Date());
        comParamMapper.updateById(param);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteParam(long id) throws DataNotFoundException {
        ComParam param = comParamMapper.selectById(id);
        if(Objects.isNull(param)){
            throw new DataNotFoundException();
        }
        Long paramGroupId = param.getParamGroupId();
        ComParamGroup comParamGroup = comParamGroupMapper.selectById(paramGroupId);
        comParamMapper.deleteById(id);
        comParamGroup.setNum(comParamGroup.getNum() - 1);
        comParamGroupMapper.updateById(comParamGroup);
    }

    @Override
    public ComParamGroup selectParamGroupById(long id) throws DataNotFoundException {
        ComParamGroup comParamGroup = comParamGroupMapper.selectById(id);
        if(comParamGroup == null){
            throw new DataNotFoundException();
        }else {
            return comParamGroup;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteParamGroup(Long id) throws DataNotFoundException {
        ComParamGroup comParamGroup = comParamGroupMapper.selectById(id);
        if (Objects.isNull(comParamGroup)) {
            log.error("参数组不存在");
            throw new DataNotFoundException();
        }
        comParamGroupMapper.deleteById(comParamGroup.getId());
        comParamMapper.deleteByGroupId(comParamGroup.getId());
        log.info("已删除参数组{}", comParamGroup.getName());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editParamGroup(ParamGroupDto paramGroupDto) throws DataNotFoundException {
        Long groupId = paramGroupDto.getId();
        ComParamGroup comParam = comParamGroupMapper.selectById(groupId);
        if (Objects.isNull(comParam)) {
            log.error("参数组不存在");
            throw new DataNotFoundException();
        }
        comParam.setId(groupId);
        comParam.setUpdTime(new Date());
        comParam.setName(paramGroupDto.getName());
        comParamGroupMapper.updateById(comParam);
    }

    @Override
    public Page<ComParamGroup> getParamGroups(long page, long size) {
        Page<ComParamGroup> groupPage = new Page<>();
        groupPage.setSize(size);
        groupPage.setCurrent(page);
        Page<ComParamGroup> iPage = comParamGroupMapper.selectPage(groupPage, Wrappers.emptyWrapper());
        return iPage;
    }

    @Override
    public List<ComParam> getParams(long groupId) {
        List<ComParam> params = comParamMapper.selectByGroupId(groupId);
        return params;
    }

    @Override
    public ComParam selectParamById(long id) throws DataNotFoundException{
        ComParam comParam = comParamMapper.selectById(id);
        if(Objects.isNull(comParam)){
            throw new DataNotFoundException();
        }
        return comParam;
    }
}
