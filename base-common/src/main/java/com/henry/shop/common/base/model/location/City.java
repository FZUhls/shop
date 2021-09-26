package com.henry.shop.common.base.model.location;

import lombok.Data;

/**
 * @author henry1
 * 行政区实体类---市
 */
@Data
public class City {
    private Long id;
    private String cityCode;
    private String cityName;
    private String shortName;
    private String provinceCode;
    private String lng;
    private String lat;
}
