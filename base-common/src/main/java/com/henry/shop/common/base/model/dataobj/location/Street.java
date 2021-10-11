package com.henry.shop.common.base.model.dataobj.location;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author henry1
 * 行政区实体类---街道
 */
@Data
@TableName("street")
public class Street implements Serializable {
    private Long id;
    private String streetCode;
    private String areaCode;
    private String streetName;
    private String shortName;
    private String lng;
    private String lat;
}
