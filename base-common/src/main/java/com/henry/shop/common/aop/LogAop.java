package com.henry.shop.common.aop;

import com.alibaba.fastjson.JSON;
import com.henry.shop.common.base.constant.ShopLog;
import com.henry.shop.common.base.enumerate.Code;
import com.henry.shop.common.base.form.BaseResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

/**
 * @author Henry
 */
@Aspect
@Component
@Slf4j
public class LogAop {
    /**
     * 声明切入点---仅对自定义的具有RestController注解的类的共有方法进行织入
     */
    @Pointcut("@target(org.springframework.web.bind.annotation.RestController) && within(com.henry.shop..*)")
    private void controllerPointcut(){
    }
    @Around("controllerPointcut()")
    public Object doLog(ProceedingJoinPoint pj) throws Throwable {
        long start = System.currentTimeMillis();
        ShopLog shopLog = new ShopLog();
        MethodSignature signature = (MethodSignature) pj.getSignature();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //get class
        Class<?> type = signature.getDeclaringType();
        String className = type.getName();
        Method method = signature.getMethod();
        String methodName = method.getName();
        String ip = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        String url = request.getRequestURL().toString();
        //获取方法上的swagger注解
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        //当存在apiOperation注解时，日志方法描述为注解的value，否则为空
        String description = apiOperation != null ? apiOperation.value() : "";
        Map<String ,String []> paramsMap = request.getParameterMap();
        shopLog.setClassName(className);
        shopLog.setMethodName(methodName);
        shopLog.setIp(ip);
        shopLog.setDescription(description);
        shopLog.setParameter(paramsMap);
        shopLog.setHttpMethod(httpMethod);
        shopLog.setUrl(url);
        //执行方法
        Object res = pj.proceed();
        BaseResponse result = null;
        if(res instanceof BaseResponse){
            result = (BaseResponse) res;
        }
        shopLog.setCode(Optional.ofNullable(result).map(BaseResponse::getCode).map(Code::getCode).map(String::valueOf).orElse("NotDefined"));
        shopLog.setMsg(Optional.ofNullable(result).map(BaseResponse::getMsg).orElse("empty"));
        //执行时间
        shopLog.setSpendTime(System.currentTimeMillis() - start);
        log.info(JSON.toJSONString(shopLog));
        return result;
    }
}
