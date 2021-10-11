package com.henry.shop.common.base.model.dataobj.location;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author henry
 * 行政区实体类---省
 */
@Data
@ApiModel("省份")
@TableName("province")
public class Province implements Serializable {
    @ApiModelProperty("省份id")
    private Long id;
    @ApiModelProperty("省份编号")
    private String provinceCode;
    @ApiModelProperty("省份名称")
    private String provinceName;
    @ApiModelProperty("省份简称")
    private String shortName;
    @ApiModelProperty("省份经度")
    private String lng;
    @ApiModelProperty("省份纬度")
    private String lat;
}
