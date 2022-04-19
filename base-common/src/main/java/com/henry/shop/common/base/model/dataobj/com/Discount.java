package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author wjh
 * date  2022/4/14
 * 折扣
 */
@TableName("com_discount")
@Data
@ApiModel("折扣")
public class Discount {
    @ApiModelProperty("折扣商品ID")
    private Long id;
    /**
     * 折扣商品ID，唯一性，主键
     */

    @ApiModelProperty("商品ID")
    private Long commodity_id;
    /**
     * 商品ID,外键
     */

    @ApiModelProperty("商品名称")
    private String commodityName;
    /**
     * 商品名称
     */

    @ApiModelProperty("品牌ID")
    private Long brand_id;
    /**
     * 商品ID,外键
     */

    @ApiModelProperty("品牌名称")
    private String brandName;
    /**
     * 商品名称
     */

    @ApiModelProperty("折扣率")
    private Double discountRate;
    /**
     * 折扣率
     */

    @ApiModelProperty("创建时间")
    private Date creTime;
    /**
     * 创建时间
     */

    @ApiModelProperty("更新时间")
    private Date updTime;
    /**
     * 更新时间
     */

    @ApiModelProperty("是否开启打折")
    private Boolean enable;
    /**
     * 是否开启打折
     */
}
