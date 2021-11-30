package com.henry.shop.commodity.api;

import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * 商品规格管理接口
 * @author Henry
 */
@FeignClient(value = "commodity-center")
public interface VariantRestService {
    String BASE_URL = "/commodity/variant";
    String CREATE_GROUP = BASE_URL + "/createGroup";
    String CREATE = BASE_URL + "/create";
    String FIND_VARIANT = BASE_URL + "/findVariant/{id}";
    String FIND_VARIANT_GROUP = BASE_URL + "/findGroup/{id}";
    String UPDATE_VARIANT = BASE_URL + "/update/{id}";
    String UPDATE_GROUP = BASE_URL + "/updateGroup/{id}";
    String DELETE = BASE_URL + "/delete/{id}";
    String DELETE_GROUP = BASE_URL + "/deleteGroup/{id}";
    @PostMapping(CREATE_GROUP)
    BaseResponse createVariantGroup(@RequestBody VariantGroupDto variantGroupDto);

    @PostMapping(CREATE)
    BaseResponse createVariant(@RequestBody VariantDto variantDto);

    @GetMapping(FIND_VARIANT)
    BaseResponse<ComVariant> selectVariant(@PathVariable("id") long id);

    @GetMapping(FIND_VARIANT_GROUP)
    BaseResponse<ComVariantGroup> selectGroup(@PathVariable("id") long id);

    @PutMapping(UPDATE_VARIANT)
    BaseResponse<ComVariant> updateVariant(@PathVariable("id") long id, @RequestBody VariantDto variantDto);

    @PutMapping(UPDATE_GROUP)
    BaseResponse<ComVariantGroup> updateGroup(@PathVariable("id") long id, @RequestBody VariantGroupDto variantGroupDto);

    @DeleteMapping(DELETE)
    BaseResponse delete(@PathVariable("id") long id);

    @DeleteMapping(DELETE_GROUP)
    BaseResponse deleteGroup(@PathVariable("id") long id);
}
