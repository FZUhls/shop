package com.henry.shop.common.base.model.dataobj.com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author henry1
 * 商品规格组表
 */
@Data
@TableName("com_variant_group")
public class ComVariantGroup {
    private Long id;
    /**
     * 规格项数量
     */
    private Long variantNumber;
    /**
     * 规格组名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date creTime;
    /**
     * 更新时间
     */
    private Date updTime;
}
