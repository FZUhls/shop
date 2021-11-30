package com.henry.shop.business.commodity.controller;

import com.henry.shop.business.commodity.vo.req.VariantGroupVo;
import com.henry.shop.commodity.api.VariantRestService;
import com.henry.shop.commodity.dto.req.VariantGroupDto;
import com.henry.shop.common.base.form.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        variantGroupDto.setName(variantGroupDto.getName());
        BaseResponse response = variantRestService.createVariantGroup(variantGroupDto);
        return response;
    }
}
