package com.henry.shop.business.commodity.controller;

import com.henry.shop.business.commodity.vo.req.VariantGroupVo;
import com.henry.shop.business.commodity.vo.req.VariantVo;
import com.henry.shop.commodity.api.VariantRestService;
import com.henry.shop.commodity.dto.req.VariantDto;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.ComVariant;
import com.henry.shop.common.base.model.dataobj.com.ComVariantGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品规格Controller
 * @author Henry
 */
@RestController
@Slf4j
@Api(tags = "商品管理--规格",value = "规格管理")
public class VariantController {
    private static final String BASE_URL = "/commodity/variant";
    private static final String CREATE_GROUP = BASE_URL + "/createGroup";
    private static final String CREATE = BASE_URL + "/create";
    private static final String FIND_VARIANT = BASE_URL + "/findVariant/{id}";
    private static final String FIND_VARIANT_GROUP = BASE_URL + "/findGroup/{id}";
    private static final String FIND_VARIANT_BY_GROUP_ID = BASE_URL + "/findByGroupId/{groupId}";
    private static final String UPDATE_VARIANT = BASE_URL + "/update/{id}";
    private static final String UPDATE_GROUP = BASE_URL + "/updateGroup/{id}";
    private static final String DELETE = BASE_URL + "/delete/{id}";
    private static final String DELETE_GROUP = BASE_URL + "/deleteGroup/{id}";

    @Autowired
    VariantRestService variantRestService;

    @PostMapping(CREATE_GROUP)
    @ApiOperation("创建规格组")
    public BaseResponse createGroup(VariantGroupVo variantGroupVo){
        VariantGroupDto variantGroupDto = new VariantGroupDto();
        BeanUtils.copyProperties(variantGroupVo,variantGroupDto);
        return variantRestService.createVariantGroup(variantGroupDto);
    }

    @PostMapping(CREATE)
    @ApiOperation("创建规格")
    public BaseResponse create(VariantVo variantVo){
        VariantDto variantDto = new VariantDto();
        BeanUtils.copyProperties(variantVo,variantDto);
        return variantRestService.createVariant(variantDto);
    }

    @GetMapping(FIND_VARIANT_GROUP)
    @ApiOperation("根据id查询规格组")
    public BaseResponse<ComVariantGroup> findVariantGroup(@PathVariable("id") long id){
        return variantRestService.selectGroup(id);
    }

    @GetMapping(FIND_VARIANT)
    @ApiOperation("根据id查询规格")
    public BaseResponse<ComVariant> findVariant(@PathVariable("id") long id){
        return variantRestService.selectVariant(id);
    }

    @GetMapping(FIND_VARIANT_BY_GROUP_ID)
    @ApiOperation("查询组内规格")
    public BaseResponse<List<ComVariant>> findVariantsByGroupId(@PathVariable("groupId") long groupId){
        return variantRestService.selectVariantByGroupId(groupId);
    }

    @PutMapping(UPDATE_GROUP)
    @ApiOperation("更新规格组")
    public BaseResponse<ComVariantGroup> updateGroup(@PathVariable("id") long id,VariantGroupVo variantGroupVo){
        VariantGroupDto variantGroupDto = new VariantGroupDto();
        BeanUtils.copyProperties(variantGroupVo,variantGroupDto);
        return variantRestService.updateGroup(id,variantGroupDto);
    }

    @PutMapping(UPDATE_VARIANT)
    @ApiOperation("更新规格")
    public BaseResponse<ComVariant> update(@PathVariable("id") long id,VariantVo variantVo){
        VariantDto variantDto = new VariantDto();
        BeanUtils.copyProperties(variantVo,variantDto);
        return variantRestService.updateVariant(id,variantDto);
    }

    @PutMapping(DELETE_GROUP)
    @ApiOperation("根据id删除规格组")
    public BaseResponse deleteGroup(@PathVariable("id") long id){
        return variantRestService.deleteGroup(id);
    }

    @PutMapping(DELETE)
    @ApiOperation("根据id删除规格")
    public BaseResponse delete(@PathVariable("id") long id){
        return variantRestService.delete(id);
    }
}
