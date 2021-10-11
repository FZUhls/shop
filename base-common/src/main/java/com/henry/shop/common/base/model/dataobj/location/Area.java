package com.henry.shop.common.base.model.dataobj.location;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author henry1
 * 行政区实体类---区
 */
@Data
@TableName("area")
public class Area implements Serializable {
    private Long id;
    private String areaCode;
    private String CityCode;
    private String areaName;
    private String shortName;
    private String lng;
    private String lat;
}
