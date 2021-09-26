package com.henry.shop.common.base.model.location;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author henry
 * 行政区实体类---省
 */
@Data
@TableName("province")
public class Province {
    private Long id;
    private String provinceCode;
    private String provinceName;
    private String shortName;
    private String lng;
    private String lat;
}
