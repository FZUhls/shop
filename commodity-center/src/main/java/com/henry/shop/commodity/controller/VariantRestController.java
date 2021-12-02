package com.henry.shop.commodity.controller;

import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.commodity.service.VariantService;
import com.henry.shop.common.base.exception.DataNotFoundException;
import com.henry.shop.common.base.exception.VariantException;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品规格controller
 * @author Henry
 */
@RestController
@Slf4j
public class VariantRestController {
    @Autowired
    private VariantService variantService;

    private static final String BASE_URL = "/commodity/variant";
    private static final String CREATE_GROUP = BASE_URL + "/createGroup";
    private static final String CREATE = BASE_URL + "/create";
    private static final String FIND_VARIANT = BASE_URL + "/findVariant/{id}";
    private static final String FIND_VARIANTS_IN_GROUP = BASE_URL + "findVariants/{groupId}";
    private static final String FIND_VARIANT_GROUP = BASE_URL + "/findGroup/{id}";
    private static final String UPDATE_VARIANT = BASE_URL + "/update/{id}";
    private static final String UPDATE_GROUP = BASE_URL + "/updateGroup/{id}";
    private static final String DELETE = BASE_URL + "/delete/{id}";
    private static final String DELETE_GROUP = BASE_URL + "/deleteGroup/{id}";
    @PostMapping(CREATE_GROUP)
    public BaseResponse createVariantGroup(@RequestBody VariantGroupDto variantGroupDto){
        variantService.createVariantGroup(variantGroupDto);
        return BaseResponse.succ();
    }
    @PostMapping(CREATE)
    public BaseResponse createVariant(@RequestBody VariantDto variantDto){
        try {
            variantService.createVariant(variantDto);
            return BaseResponse.succ();
        } catch (DataNotFoundException | VariantException e) {
            e.printStackTrace();
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }
    @GetMapping(FIND_VARIANT)
    public BaseResponse<ComVariant> selectVariant(@PathVariable("id") long id){
        try {
            ComVariant variant = variantService.getVariantById(id);
            BaseResponse<ComVariant> response = BaseResponse.succ();
            response.setData(variant);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }

    /**
     * @param groupId 根据规格组id查询组内规格
     * @return 组内规格
     */
    @GetMapping(FIND_VARIANTS_IN_GROUP)
    public BaseResponse<List<ComVariant>> selectVariantByGroupId(@PathVariable("groupId") long groupId){
        List<ComVariant> variants = variantService.getVariantByGroupId(groupId);
        BaseResponse succ = BaseResponse.succ();
        succ.setData(variants);
        return succ;
    }

    @GetMapping(FIND_VARIANT_GROUP)
    public BaseResponse<ComVariantGroup> selectGroup(@PathVariable("id") long id){
        try {
            ComVariantGroup variantGroup = variantService.getVariantGroupById(id);
            BaseResponse<ComVariantGroup> response = BaseResponse.succ();
            response.setData(variantGroup);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }
    @PutMapping(UPDATE_VARIANT)
    public BaseResponse<ComVariant> updateVariant(@PathVariable("id") long id, @RequestBody VariantDto variantDto){
        try {
            ComVariant variant = variantService.updateVariant(id, variantDto);
            BaseResponse<ComVariant> response = BaseResponse.succ();
            response.setData(variant);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }
    @PutMapping(UPDATE_GROUP)
    public BaseResponse<ComVariantGroup> updateGroup(@PathVariable("id") long id, @RequestBody VariantGroupDto variantGroupDto){
        try {
            ComVariantGroup variantGroup = variantService.updateVariantGroup(id, variantGroupDto);
            BaseResponse<ComVariantGroup> response = BaseResponse.succ();
            response.setData(variantGroup);
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }
    @DeleteMapping(DELETE)
    public BaseResponse delete(@PathVariable("id") long id){
        try {
            variantService.deleteVariant(id);
            BaseResponse<ComVariantGroup> response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }
    @DeleteMapping(DELETE_GROUP)
    public BaseResponse deleteGroup(@PathVariable("id") long id){
        try {
            variantService.deleteVariantGroup(id);
            BaseResponse<ComVariantGroup> response = BaseResponse.succ();
            return response;
        } catch (DataNotFoundException e) {
            log.error("根据id获取规格发生异常，异常消息 = {}，异常栈 = ",e.getLocalizedMessage(),e);
            BaseResponse response = BaseResponse.fail();
            response.setMsg(e.getLocalizedMessage());
            return response;
        }
    }

}
