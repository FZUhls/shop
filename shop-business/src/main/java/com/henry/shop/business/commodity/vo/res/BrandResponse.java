package com.henry.shop.business.commodity.vo.res;

import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Henry
 */
@ApiModel("品牌查询响应对象")
@Data
public class BrandResponse extends BaseResponse {
    Brand brand;
}
