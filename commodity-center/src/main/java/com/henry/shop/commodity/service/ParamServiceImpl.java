package com.henry.shop.commodity.service;

import com.henry.shop.commodity.api.ParamService;
import com.henry.shop.commodity.dto.ParamDto;
import com.henry.shop.commodity.dto.ParamGroupDto;
import com.henry.shop.common.base.mapper.com.ComParamGroupMapper;
import com.henry.shop.common.base.mapper.com.ComParamMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Henry
 */
@DubboService
public class ParamServiceImpl implements ParamService {

    @Autowired
    ComParamGroupMapper comParamGroupMapper;
    @Autowired
    ComParamMapper comParamMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createParamGroup(ParamGroupDto paramGroupDto) {
        List<ParamDto> paramDtos = paramGroupDto.getParams();
        String paramGroupName = paramGroupDto.getName();
        ComParamGroup comParamGroup = new ComParamGroup();
        comParamGroup.setName(paramGroupName);
        comParamGroup.setNum(paramDtos.size());
        comParamGroup.setCreTime(new Date());
        comParamGroup.setUpdTime(new Date());
        comParamGroupMapper.insert()
    }

    @Override
    public void addParamToGroup(ParamDto paramDto) {

    }

    @Override
    public void deleteParamGroup(Long id) {

    }

    @Override
    public void editParamGroup(ParamGroupDto paramGroupDto) {

    }
}
