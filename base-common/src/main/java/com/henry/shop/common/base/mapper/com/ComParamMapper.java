package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParam;

import java.util.List;

/**
 * @author henry1
 * 商品参数项 mapper类
 */
public interface ComParamMapper extends BaseMapper<ComParam> {
    List<ComParam> selectByGroupId(long groupId);
    int deleteByGroupId(long groupId);
}
