package com.henry.shop.common.base.mapper.com;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.common.base.model.dataobj.com.Commodity;
import org.apache.ibatis.annotations.Param;

/**
 * @author henry1
 * 商品表mapper类
 */
public interface CommodityMapper extends BaseMapper<Commodity> {
    Page<Commodity> getByPage(Page<Commodity> page, @Param("keyword") String keyword);
}
