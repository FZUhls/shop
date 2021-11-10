package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import org.apache.ibatis.annotations.Param;

/**
 * @author henry1
 * 商品规格项 mapper类
 */
public interface ComVariantMapper extends BaseMapper<ComVariant> {
    void deleteByGroupId(@Param("groupId") long groupId, @Param("num") int num);
}
