package com.henry.shop.common.base.form;
/**
 * @author Henry
 * 基础应答表单类
 */
public class BaseResponse {
    /**
     * 响应状态码
     * 1为成功，0为失败，-1为系统异常
     */
    protected Integer code;
    /**
     * 响应消息
     */
    protected Integer msg;
    /**
     * 响应内容
     */
    protected Integer data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getMsg() {
        return msg;
    }

    public void setMsg(Integer msg) {
        this.msg = msg;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
