package com.henry.shop.common.base.form;

import com.henry.shop.common.base.constant.BaseConstant;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 * 基础应答表单类
 */
@Data
public class BaseResponse implements Serializable {
    /**
     * 响应状态码
     * 1为成功，0为失败，-1为系统异常
     */
    @ApiParam("响应状态码")
    protected Integer code;
    /**
     * 响应消息
     */
    @ApiParam("响应消息")
    protected String msg;

    /**
     * 返回一个基本的失败的响应对象
     * @return BaseRespinse
     */
    public static BaseResponse fail(){
        BaseResponse response = new BaseResponse();
        response.setCode(BaseConstant.FAIL_CODE);
        response.setMsg("请求失败");
        return response;
    }
    /**
     * 返回一个基本的成功的响应对象
     * @return BaseRespinse
     */
    public static BaseResponse succ(){
        BaseResponse response = new BaseResponse();
        response.setCode(BaseConstant.SUCC_CODE);
        response.setMsg("请求成功");
        return response;
    }
}
