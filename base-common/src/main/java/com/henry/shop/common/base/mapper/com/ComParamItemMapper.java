package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.henry.shop.common.base.model.dataobj.com.ComParamItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author henry1
 * 商品参数item表
 */
public interface ComParamItemMapper extends BaseMapper<ComParamItem> {
    List<ComParamItem> selectByCommodityId(@Param("comId") long comId);
}
