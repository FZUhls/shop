package com.henry.shop.business.commodity.vo.res;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 * 品牌分页查询应答类
 */
@ApiModel("品牌分页查询响应类")
@Data
public class BrandPageResponse extends BaseResponse implements Serializable {
    @ApiModelProperty("品牌")
    IPage<Brand> brandPage;
}
