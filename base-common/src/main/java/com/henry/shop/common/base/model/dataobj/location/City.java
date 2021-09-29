package com.henry.shop.common.base.model.dataobj.location;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author henry1
 * 行政区实体类---市
 */
@Data
@TableName("city")
public class City {
    private Long id;
    private String cityCode;
    private String cityName;
    private String shortName;
    private String provinceCode;
    private String lng;
    private String lat;
}
