package com.henry.shop.commodity.service.impl;

import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.commodity.service.VariantService;
import com.henry.shop.common.base.exception.DataBaseNotFoundException;
import com.henry.shop.common.base.mapper.com.ComVariantGroupMapper;
import com.henry.shop.common.base.mapper.com.ComVariantMapper;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;


@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    ComVariantGroupMapper comVariantGroupMapper;
    @Autowired
    ComVariantMapper comVariantMapper;
    @Override
    public ComVariantGroup getVariantGroupById(long groupId) throws DataBaseNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(groupId);
        if(Objects.isNull(variantGroup)){
            throw new DataBaseNotFoundException();
        }
        return variantGroup;
    }

    @Override
    public ComVariant getVariantById(long id) throws DataBaseNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataBaseNotFoundException();
        }
        return variant;
    }

    @Override
    public ComVariantGroup createVariantGroup(VariantGroupDto variantGroupDto) {
        ComVariantGroup variantGroup = new ComVariantGroup();
        variantGroup.setName(variantGroupDto.getName());
        variantGroup.setVariantNumber(0);
        variantGroup.setCreTime(new Date());
        variantGroup.setUpdTime(new Date());
        comVariantGroupMapper.insert(variantGroup);
        return variantGroup;
    }

    @Override
    public ComVariant createVariant(VariantDto variantDto) {
        ComVariant variant = new ComVariant();
        variant.setGroupId(variantDto.getGroupId());
        variant.setName(variantDto.getName());
        variant.setCreTime(new Date());
        variant.setUpdTime(new Date());
        comVariantMapper.insert(variant);
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(variantDto.getGroupId());
        variantGroup.setVariantNumber(variantGroup.getVariantNumber()+1);
        comVariantGroupMapper.updateById(variantGroup);
        return variant;
    }

    @Override
    public ComVariantGroup updateVariantGroup(long id, VariantGroupDto variantGroupDto) throws DataBaseNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(id);
        if(Objects.isNull(variantGroup)){
            throw new DataBaseNotFoundException();
        }
        variantGroup.setName(variantGroup.getName());
        variantGroup.setUpdTime(new Date());
        comVariantGroupMapper.updateById(variantGroup);
        return variantGroup;
    }

    @Override
    public ComVariant updateVariant(long id, VariantDto variantDto) throws DataBaseNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataBaseNotFoundException();
        }
        variant.setName(variantDto.getName());
        variant.setGroupId(variant.getGroupId());
        variant.setUpdTime(new Date());
        comVariantMapper.updateById(variant);
        return variant;
    }

    @Override
    public void deleteVariantGroup(long id) throws DataBaseNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(id);
        if(Objects.isNull(variantGroup)){
            throw new DataBaseNotFoundException();
        }
        comVariantGroupMapper.deleteById(id);
        comVariantMapper.deleteByGroupId(id,variantGroup.getVariantNumber());
    }

    @Override
    public void deleteVariant(long id) throws DataBaseNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataBaseNotFoundException();
        }
        Long groupId = variant.getGroupId();
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(groupId);
        variantGroup.setVariantNumber(variantGroup.getVariantNumber() - 1);
        comVariantGroupMapper.updateById(variantGroup);
        comVariantMapper.deleteById(id);
    }
}
