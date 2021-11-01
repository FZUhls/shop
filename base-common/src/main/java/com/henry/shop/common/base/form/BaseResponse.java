package com.henry.shop.common.base.form;

import com.henry.shop.common.base.enumerate.Code;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Henry
 * 基础应答表单类
 */
@Data
@ApiModel("基础响应类")
public class BaseResponse<T> implements Serializable {
    /**
     * 响应状态码
     * 1为成功，0为失败，-1为系统异常
     */
    @ApiModelProperty("响应状态码")
    protected Code code;
    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    protected String msg;

    @ApiModelProperty("响应消息")
    protected T data;


    /**
     * 返回一个基本的失败的响应对象
     * @return BaseRespinse
     */
    public static BaseResponse fail(){
        BaseResponse response = new BaseResponse();
        response.setCode(Code.FAIL);
        response.setMsg(Code.FAIL.getDescription());
        return response;
    }
    /**
     * 返回一个基本的成功的响应对象
     * @return BaseRespinse
     */
    public static BaseResponse succ(){
        BaseResponse response = new BaseResponse();
        response.setCode(Code.SUCCESS);
        response.setMsg(Code.SUCCESS.getDescription());
        return response;
    }
    public static BaseResponse systemError(){
        BaseResponse response = new BaseResponse();
        response.setCode(Code.SYSTEM_ERROR);
        response.setMsg(Code.SYSTEM_ERROR.getDescription());
        return response;
    }
}
