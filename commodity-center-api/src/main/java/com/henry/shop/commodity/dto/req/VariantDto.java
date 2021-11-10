package com.henry.shop.commodity.dto.req;

import lombok.Data;

/**
 * 规格dto
 * @author Henry
 * @see com.henry.shop.common.base.model.dataobj.com.ComVariant
 */
@Data
public class VariantDto {
    /**
     * 规格名
     */
    private String name;
    /**
     * 规格组id
     */
    private long groupId;
}
