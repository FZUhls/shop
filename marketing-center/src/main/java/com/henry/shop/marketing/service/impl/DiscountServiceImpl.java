package com.henry.shop.marketing.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.marketing.dto.req.DiscountDto;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.mapper.com.DiscountMapper;
import com.henry.shop.common.base.model.dataobj.com.Discount;
import com.henry.shop.marketing.service.DiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.Objects;

/**
 * @author wjh
 * date  2022/4/18
 */
@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountMapper discountMapper;

    @Override
    public Discount selectById(long id) {
        return discountMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Discount add(DiscountDto discountDto) {
        log.info("插入单条折扣数据，请求参数为 {}", JSON.toJSONString(discountDto));
        Discount discount = new Discount();
        discount.setDiscountRate(discountDto.getDiscountRate());
        discount.setCommodity_id(discountDto.getCommodity_id());
        discount.setCommodityName(discountDto.getCommodityName());
        discount.setBrand_id(discountDto.getBrand_id());
        discount.setBrandName(discountDto.getBrandName());
        discount.setCreTime(new Date());
        discount.setUpdTime(new Date());
        discount.setEnable(true);
        return discount;
    }

    @Override
    public Page<Discount> selectByPage(long pageNo, long size, String keyword) {
        Page<Discount> page = new Page<>();
        page.setCurrent(pageNo);
        page.setSize(size);
        QueryWrapper<Discount> wrapper = new QueryWrapper<>();
        if(StrUtil.isNotBlank(keyword)){
            wrapper.like("name",keyword);
        }
        return discountMapper.selectPage(page, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Discount updateDiscount(long id, DiscountDto discountDto) throws DataNotFoundException {
        //判断是否为空
        Discount discount = discountMapper.selectById(id);
        if(Objects.isNull(discount)){
            throw new DataNotFoundException();
        }
        //对数据进行修改
        discount.setDiscountRate(discountDto.getDiscountRate());
        discount.setEnable(discountDto.getEnable());
        discount.setUpdTime(new Date());
        discountMapper.updateById(discount);
        return discount;
    }

    @Override
    public void deleteDiscount(long id) throws DataNotFoundException {
        Discount discount = discountMapper.selectById(id);
        if(Objects.isNull(discount)){
            throw new DataNotFoundException();
        }
        //删除折扣商品
        discountMapper.deleteById(id);
    }


}
