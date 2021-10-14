package com.henry.shop.business.commodity.vo.res;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.henry.shop.common.base.form.BaseResponse;
import com.henry.shop.common.base.model.dataobj.com.Brand;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Henry
 * 品牌分页查询应答类
 */
@ApiModel("品牌分页查询响应类")
@Data
public class BrandPageResponse extends BaseResponse {
    IPage<Brand> brandPage;
}
