package com.henry.shop.marketing.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.marketing.dto.req.DiscountDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.model.dataobj.com.Discount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author wjh
 * date  2022/4/14
 */
@FeignClient("marketing-center")
public interface DiscountService {
    /**
     * @param id 根据分类id查询类别
     * @return 折扣
     */
    Discount selectById(long id);

    /**
     * @param discountDto 折扣dto
     * @return 折扣
     */
    Discount add( DiscountDto discountDto);


    /**
     * @param pageNo 页码，
     * @param size 分页大小
     * @param keyword 搜索关键字
     * @return 关键字搜索结果
     */
    Page<Discount> selectByPage(long pageNo, long size, String keyword);

    /**
     * @param id 折扣商品id，
     * @param discountDto ,修改请求参数
     * @throws DataNotFoundException 折扣商品不存在时抛出
     */
    @Transactional(rollbackFor = Exception.class)
    Discount updateDiscount(long id, DiscountDto discountDto) throws DataNotFoundException;


    /**
     * @param id 折扣商品id
     * @throws DataNotFoundException 折扣商品不存在时抛出
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteDiscount(long id) throws DataNotFoundException;
}
