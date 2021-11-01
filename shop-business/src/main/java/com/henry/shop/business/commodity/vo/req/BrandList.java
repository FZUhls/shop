package com.henry.shop.business.commodity.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("批量添加品牌表单类")
public class BrandList implements Serializable {
    @ApiParam("数量")
    private int num;
    @ApiParam("品牌列表")
    private List<BrandReq> brandVoList;
}
