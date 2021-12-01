package com.henry.shop.business.commodity.controller;

import com.henry.shop.business.commodity.vo.req.VariantGroupVo;
import com.henry.shop.business.commodity.vo.req.VariantVo;
import com.henry.shop.commodity.api.VariantRestService;
import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品规格Controller
 * @author Henry
 */
@RestController
@Slf4j
public class VariantController {
    private static final String BASE_URL = "/commodity/variant";
    private static final String CREATE_GROUP = BASE_URL + "/createGroup";
    private static final String CREATE = BASE_URL + "/create";
    private static final String FIND_VARIANT = BASE_URL + "/findVariant/{id}";
    private static final String FIND_VARIANT_GROUP = BASE_URL + "/findGroup/{id}";
    private static final String UPDATE_VARIANT = BASE_URL + "/update/{id}";
    private static final String UPDATE_GROUP = BASE_URL + "/updateGroup/{id}";
    private static final String DELETE = BASE_URL + "/delete/{id}";
    private static final String DELETE_GROUP = BASE_URL + "/deleteGroup/{id}";

    @Autowired
    VariantRestService variantRestService;

    @PostMapping(CREATE_GROUP)
    public BaseResponse createGroup(VariantGroupVo variantGroupVo){
        VariantGroupDto variantGroupDto = new VariantGroupDto();
        BeanUtils.copyProperties(variantGroupVo,variantGroupDto);
        return variantRestService.createVariantGroup(variantGroupDto);
    }
    @PostMapping(CREATE)
    public BaseResponse create(VariantVo variantVo){
        VariantDto variantDto = new VariantDto();
        BeanUtils.copyProperties(variantVo,variantDto);
        return variantRestService.createVariant(variantDto);
    }
    @GetMapping(FIND_VARIANT_GROUP)
    public BaseResponse<ComVariantGroup> findVariantGroup(@PathVariable("id") long id){
        return variantRestService.selectGroup(id);
    }
    @GetMapping(FIND_VARIANT)
    public BaseResponse<ComVariant> findVariant(@PathVariable("id") long id){
        return variantRestService.selectVariant(id);
    }
    @PutMapping(UPDATE_GROUP)
    public BaseResponse<ComVariantGroup> updateGroup(@PathVariable("id") long id,VariantGroupVo variantGroupVo){
        VariantGroupDto variantGroupDto = new VariantGroupDto();
        BeanUtils.copyProperties(variantGroupVo,variantGroupDto);
        return variantRestService.updateGroup(id,variantGroupDto);
    }
    @PutMapping(UPDATE_VARIANT)
    public BaseResponse<ComVariant> update(@PathVariable("id") long id,VariantVo variantVo){
        VariantDto variantDto = new VariantDto();
        BeanUtils.copyProperties(variantVo,variantDto);
        return variantRestService.updateVariant(id,variantDto);
    }
    @PutMapping(DELETE_GROUP)
    public BaseResponse deleteGroup(@PathVariable("id") long id){
        return variantRestService.deleteGroup(id);
    }
    @PutMapping(DELETE)
    public BaseResponse delete(@PathVariable("id") long id){
        return variantRestService.delete(id);
    }
}
