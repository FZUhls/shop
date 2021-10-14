package com.henry.shop.common.test.mapper;

import com.henry.shop.common.base.mapper.com.BrandMapper;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import com.henry.shop.common.test.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class BrandMapperTest extends BaseTest {
    @Autowired
    BrandMapper brandMapper;
    @Test
    void insert(){
        int insert = brandMapper.insert(newBrand());
        log.info("插入结果 {}",insert);
    }
    @Test
    void insertBranch(){
        List<Brand> brandList = new ArrayList<>();
        brandList.add(newBrand());
        brandList.add(newBrand());
        int i = brandMapper.insertBranch(brandList);
        log.info("插入结果 {}",i);
    }
    private Brand newBrand(){
        Brand brand = new Brand();
        brand.setBrandName("NIKE");
        brand.setBrandCode("00100");
        brand.setUpdTime(new Date());
        brand.setCreTime(new Date());
        return brand;
    }
}
