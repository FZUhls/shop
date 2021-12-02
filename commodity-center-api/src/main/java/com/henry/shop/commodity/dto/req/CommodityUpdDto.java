package com.henry.shop.commodity.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@ApiModel("商品dto")
public class CommodityUpdDto {
    /**
     * 商品名
     */
    @ApiModelProperty("商品名")
    private String name;

    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private List<String> imageUrls;

    /**
     * 是否有添加新的规格
     */
    private boolean isNewVariant;

    /**
     * skuDto list， 当有新规格添加时才有新的sku添加
     */
    private List<SkuDto> newSkuDtoList;
}
