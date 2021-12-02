package com.henry.shop.commodity.service.impl;

import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.commodity.service.VariantService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.VariantException;
import com.henry.shop.common.base.mapper.com.ComVariantGroupMapper;
import com.henry.shop.common.base.mapper.com.ComVariantMapper;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    ComVariantGroupMapper comVariantGroupMapper;
    @Autowired
    ComVariantMapper comVariantMapper;
    private static final Integer MAX_VARIANT_NUM = 3;
    @Override
    public ComVariantGroup getVariantGroupById(long groupId) throws DataNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(groupId);
        if(Objects.isNull(variantGroup)){
            throw new DataNotFoundException();
        }
        return variantGroup;
    }

    @Override
    public List<ComVariant> getVariantsByGroupId(long groupId) {
        return comVariantMapper.selectByMap(Map.of("group_id",groupId));
    }

    @Override
    public ComVariant getVariantById(long id) throws DataNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataNotFoundException();
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
    public ComVariant createVariant(VariantDto variantDto) throws DataNotFoundException, VariantException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(variantDto.getGroupId());
        if(Objects.isNull(variantGroup)){
            throw new DataNotFoundException("规格组不存在");
        }
        if(variantGroup.getVariantNumber() >= 3){
            throw new VariantException("规格组参数不得超过3个");
        }
        ComVariant variant = new ComVariant();
        variant.setGroupId(variantDto.getGroupId());
        variant.setName(variantDto.getName());
        variant.setCreTime(new Date());
        variant.setUpdTime(new Date());
        comVariantMapper.insert(variant);
        variantGroup.setVariantNumber(variantGroup.getVariantNumber()+1);
        comVariantGroupMapper.updateById(variantGroup);
        return variant;
    }

    @Override
    public ComVariantGroup updateVariantGroup(long id, VariantGroupDto variantGroupDto) throws DataNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(id);
        if(Objects.isNull(variantGroup)){
            throw new DataNotFoundException();
        }
        variantGroup.setName(variantGroup.getName());
        variantGroup.setUpdTime(new Date());
        comVariantGroupMapper.updateById(variantGroup);
        return variantGroup;
    }

    @Override
    public ComVariant updateVariant(long id, VariantDto variantDto) throws DataNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataNotFoundException();
        }
        variant.setName(variantDto.getName());
        variant.setGroupId(variant.getGroupId());
        variant.setUpdTime(new Date());
        comVariantMapper.updateById(variant);
        return variant;
    }

    @Override
    public void deleteVariantGroup(long id) throws DataNotFoundException {
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(id);
        if(Objects.isNull(variantGroup)){
            throw new DataNotFoundException();
        }
        comVariantGroupMapper.deleteById(id);
        comVariantMapper.deleteByGroupId(id,variantGroup.getVariantNumber());
    }

    @Override
    public void deleteVariant(long id) throws DataNotFoundException {
        ComVariant variant = comVariantMapper.selectById(id);
        if(Objects.isNull(variant)){
            throw new DataNotFoundException();
        }
        Long groupId = variant.getGroupId();
        ComVariantGroup variantGroup = comVariantGroupMapper.selectById(groupId);
        variantGroup.setVariantNumber(variantGroup.getVariantNumber() - 1);
        comVariantGroupMapper.updateById(variantGroup);
        comVariantMapper.deleteById(id);
    }

    @Override
    public List<ComVariant> getVariantByGroupId(long groupId) {
        return comVariantMapper.selectByMap(Map.of("group_id",groupId));
    }
}
