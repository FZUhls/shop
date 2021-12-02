package com.henry.shop.commodity.dto.req;

import lombok.Data;

import java.util.List;

/**
 * @author Henry
 */
@Data
public class SkuUpdDto {
    private Long commodityId;
    private List<SkuUpdItem> updItems;
}
