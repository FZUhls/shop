package com.henry.shop.common.base.model.location;

import lombok.Data;

/**
 * @author henry1
 * 行政区实体类---区
 */
@Data
public class Area {
    private Long id;
    private String areaCode;
    private String CityCode;
    private String areaName;
    private String shortName;
    private String lng;
    private String lat;
}
