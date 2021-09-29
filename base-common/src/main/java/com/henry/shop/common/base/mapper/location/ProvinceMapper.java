package com.henry.shop.common.base.mapper.location;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.location.Province;

import java.util.List;

public interface ProvinceMapper extends BaseMapper<Province> {
    List<Province> findAll();
}
