package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品添加表单
 * @see com.henry.shop.common.base.model.dataobj.com.Commodity
 * @author Henry
 */
@Data
@ToString
@ApiModel("商品dto")
public class CommodityDto implements Serializable {
    /**
     * 商品名
     */
    @ApiModelProperty("商品名")
    private String name;
    /**
     * 分类
     */
    @ApiModelProperty("类别id")
    private Long categoryId;
    /**
     * 规格组id
     */
    @ApiModelProperty("规格组id")
    private Long variantGropuId;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Long brandId;

    /**
     * 规格map
     */
    @ApiModelProperty("规格map")
    private Map<Long,String> variantMap;
    /**
     * sku 列表
     */
    @ApiModelProperty("sku列表")
    private List<SkuDto> skuDtoList;
}
