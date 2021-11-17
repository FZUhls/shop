package com.henry.shop.commodity.dto.req;

import lombok.Data;

/**
 * <p>参数项 dto</p>
 * @see com.henry.shop.common.base.model.dataobj.com.ComParamItem
 * @author Henry
 */
@Data
public class ParamItemDto {
    /**
     * 参数项id
     */
    private long paramId;

    /**
     * 值
     */
    private String value;
}
