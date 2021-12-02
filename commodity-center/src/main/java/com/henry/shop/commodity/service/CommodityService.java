package com.henry.shop.commodity.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.dto.req.CommodityDto;
import com.henry.shop.commodity.dto.req.CommodityUpdDto;
import com.henry.shop.commodity.dto.req.SkuUpdDto;
import com.henry.shop.commodity.dto.res.CommodityRes;
import com.henry.shop.commodity.dto.res.CommodityShortRes;
import com.henry.shop.common.base.enumerate.PublishStatus;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.ParamIllegalException;
import com.henry.shop.common.base.model.dataobj.com.Commodity;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品service
 * <ul>
 *     <li>商品增加 {@link #createCommodity(CommodityDto)}</li>
 *     <li>商品更新 {@link #updateCommodity(long, CommodityUpdDto)} (long, CommodityDto)}</li>
 *     <li>商品状态更新 {@link #updateCommodityPublishStatus(long, PublishStatus)}</li>
 *     <li>删除商品 {@link #deleteCommodity(long)}</li>
 *     <li>分页查询商品 {@link #getCommoditys(long, long, String)}</li>
 *     <li>商品状态改变 {@link #updateCommodityPublishStatus(long, PublishStatus)} </li>
 * </ul>
 * @author Henry
 * @since 2021.11.10
 * @version 1.0
 */
public interface CommodityService {
    /**
     * 创建商品
     * @param commodityDto 商品dto
     * @return 插入后的商品对象
     * @throws DataNotFoundException 插入商品所属的分类或品牌不存在
     * @throws ParamIllegalException 参数错误
     */
    @Transactional(rollbackFor = Exception.class)
    Commodity createCommodity(CommodityDto commodityDto) throws DataNotFoundException, ParamIllegalException;

    /**
     * 更新商品
     * @param id 被更新的商品的id
     * @param commodityUpdDto 商品更新dto
     * @return 更新后的商品对象
     * @throws DataNotFoundException 更新商品的品牌、分类或被更新项不存在
     */
    @Transactional(rollbackFor = Exception.class)
    Commodity updateCommodity(long id, CommodityUpdDto commodityUpdDto) throws DataNotFoundException;

    /**
     * @param skuUpdDto sku 更新 dto
     */
    @Transactional(rollbackFor = Exception.class)
    void updateSku(SkuUpdDto skuUpdDto);

    /**
     * @param id 商品id
     * @throws DataNotFoundException 商品不存在时抛出
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteCommodity(long id) throws DataNotFoundException;

    /**
     * @param id 商品id
     * @return 商品信息
     * @throws DataNotFoundException 商品不存在时抛出
     */
    CommodityRes selectById(long id) throws DataNotFoundException;

    /**
     * 分页获取商品
     * @param pageNo 页号
     * @param size 分页大小
     * @param keyWord 关键词
     * @return 商品分页列表
     */
    @Transactional(rollbackFor = Exception.class)
    Page<CommodityShortRes> getCommoditys(long pageNo, long size, String keyWord);

    /**
     * 更新商品状态
     * @param id 商品id
     * @param publishStatus 修改的目标状态
     * @return 修改后的商品对象
     */
    @Transactional(rollbackFor = Exception.class)
    Commodity updateCommodityPublishStatus(long id, PublishStatus publishStatus) throws DataNotFoundException;
}
