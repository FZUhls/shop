package com.henry.shop.business.base;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Henry
 * controller基础类
 */
public abstract class BaseController {
    /**
     * @return HttpSession 返回当前session
     */
    protected HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * @return HttpServletRequest 返回当前会话的request对象
     */
    protected HttpServletRequest getRequest(){
        return getRequestAttributes().getRequest();
    }

    /**
     * @return HttpServletResponse 返回当前会话的response对象
     */
    protected HttpServletResponse getResponse(){
        return getRequestAttributes().getResponse();
    }
    protected ServletRequestAttributes getRequestAttributes(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes());
    }
}
