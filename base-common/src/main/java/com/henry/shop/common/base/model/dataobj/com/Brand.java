package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author henry1
 * 品牌表
 */
@TableName("com_brand")
@Data
@ApiModel("品牌")
public class Brand implements Serializable {
    @ApiModelProperty("品牌id")
    private Long id;
    /**
     * 品牌code，唯一性
     */
    @ApiModelProperty("品牌code")
    private String brandCode;
    /**
     * 品牌名
     */
    @ApiModelProperty("品牌")
    private String brandName;
    /**
     * 简称
     */
    @ApiModelProperty("简称")
    private String shortName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date creTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updTime;
}
