package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParamGroup;

/**
 * @author henry1
 * 商品参数组mapper类
 */
public interface ComParamGroupMapper extends BaseMapper<ComParamGroup> {
    /**
     * 插入一条记录，返回主键
     * @param group 参数组
     * @return long 主键
     */
    long insert0(ComParamGroup group);
}
