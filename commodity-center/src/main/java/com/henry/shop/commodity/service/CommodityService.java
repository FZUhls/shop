package com.henry.shop.commodity.service;

import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.model.dataobj.com.Commodity;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品service
 * <ul>
 *     <li>商品增加 {@link #createCommodity(CommodityDto)}</li>
 *     <li>商品更新 {@link #updateCommodity(long, CommodityDto)}</li>
 *     <li>删除商品 {@link #deleteCommodity(long)}</li>
 *     <li>分页查询商品 {@link #getCommoditys(long, long, String)}</li>
 *     <li>商品状态改变 {@link #updateCommodityPublishStatus(long, PublishStatus)} </li>
 * </ul>
 * @author Henry
 * @since 2021.11.10
 * @version 1.0
 */
public interface CommodityService {
    @Transactional(rollbackFor = Exception.class)
    Commodity createCommodity(CommodityDto commodityDto);
    @Transactional(rollbackFor = Exception.class)
    Commodity updateCommodity(long id,CommodityDto commodityDto);
    @Transactional(rollbackFor = Exception.class)
    void deleteCommodity(long id);
    @Transactional(rollbackFor = Exception.class)
    Commodity getCommoditys(long pageNo,long size,String keyWord);
    @Transactional(rollbackFor = Exception.class)
    Commodity updateCommodityPublishStatus(long id, PublishStatus publishStatus);
}
