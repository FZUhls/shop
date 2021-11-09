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

    }

    @Override
    public ComVariant createVariant(VariantDto variantDto) {
        return null;
    }

    @Override
    public ComVariantGroup updateVariantGroup(long id, VariantGroupDto variantGroupDto) throws DataBaseNotFoundException {
        return null;
    }

    @Override
    public ComVariant updateVariant(long id, VariantDto variantDto) throws DataBaseNotFoundException {
        return null;
    }

    @Override
    public void deleteVariantGroup(long id) throws DataBaseNotFoundException {

    }

    @Override
    public void deleteVariant(long id) throws DataBaseNotFoundException {

    }
}
