package com.henry.shop.commodity.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.henry.shop.commodity.api.BrandService;
import com.henry.shop.commodity.dto.BrandDto;
import com.henry.shop.common.base.enumerate.BaseExceptionType;
import com.henry.shop.common.base.exception.BaseException;
import com.henry.shop.common.base.mapper.com.BrandMapper;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Henry
 */
@DubboService
@Slf4j
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addBrandBranch(List<BrandDto> brandDtoList) {
        log.info("批量插入品牌，请求参数为{}", JSON.toJSONString(brandDtoList));
        List<Brand> brandList = brandDtoList.stream().map(this::dtoToDao).collect(Collectors.toList());
        int num = brandMapper.insertBranch(brandList);
        log.info("批量插入结束，成功插入{}条数据",num);
        return num;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addBrand(BrandDto brandVo) {
        log.info("插入单条品牌数据，请求参数为 {}",JSON.toJSONString(brandVo));
        Brand newBrand = dtoToDao(brandVo);
        int num = brandMapper.insert(newBrand);
        log.info("插入结束，成功插入{}条数据",num);
        return num;
    }

    @Override
    @Transactional(readOnly = true)
    public IPage<Brand> findBrandByName(String name, long pageNo, long size) {
        Page<Brand> page = new Page(pageNo,size);
        String keyWord = name.trim();
        log.info("分页查询条件为 {} ，name = {} ",JSON.toJSONString(page),keyWord);
        IPage<Brand> brandIPage = brandMapper.getByPageAndName(page, keyWord);
        log.info("分页查询结果为 {}",JSON.toJSONString(brandIPage));
        return brandIPage;
    }

    @Override
    @Transactional(readOnly = true)
    public IPage<Brand> getBrandList(long pageNo, long size) {
        return this.findBrandByName("",pageNo,size);
    }

    @Override
    @Transactional(readOnly = true)
    public Brand findById(long id) {
        log.info("根据id查询指定品牌，id = {}",id);
        Brand brand = brandMapper.selectById(id);
        log.info("查询结果为 = {}",JSON.toJSONString(brand));
        return brand;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(long id, BrandDto brandDto) throws BaseException {
        log.info("根据id修改品牌信息，id = {}",id);
        Brand brand = brandMapper.selectById(id);
        if(Objects.isNull(brand)){
            log.info("id = {} 的品牌不存在",id);
            throw BaseExceptionType.ENTITY_NOT_FOUND.newBaseException();
        }
        log.info("修改前的信息 = {}",JSON.toJSONString(brand));
        brand.setBrandName(brand.getBrandName());
        brand.setBrandCode(brand.getBrandCode());
        brand.setUpdTime(new Date());
        int num = brandMapper.updateById(brand);
        log.info("修改的行数为{}行",num);
        return num;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(long id) throws BaseException{
        log.info("根据id删除品牌信息，id = {}",id);
        Brand brand = brandMapper.selectById(id);
        if (Objects.isNull(brand)){
            log.info("id = {} 的品牌不存在",id);
            throw BaseExceptionType.ENTITY_NOT_FOUND.newBaseException();
        }
        log.info("被删除的品牌内容为 {}",brand);
        int num = brandMapper.deleteById(id);
        log.info("删除行数为{}行",num);
        return num;
    }

    private Brand dtoToDao(BrandDto brandDto){
        Brand brand = new Brand();
        brand.setBrandCode(brandDto.getBrandCode());
        brand.setBrandName(brandDto.getBrandName());
        brand.setCreTime(new Date());
        brand.setUpdTime(new Date());
        return brand;
    }
}
