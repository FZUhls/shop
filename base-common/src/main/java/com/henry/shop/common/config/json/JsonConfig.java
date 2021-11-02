package com.henry.shop.common.config.json;

import cn.hutool.core.lang.ClassScanner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.henry.shop.common.base.enumerate.Enumerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * json序列化配置
 *
 * @author Henry
 */
@Slf4j
@Configuration
public class JsonConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        converter.setSupportedMediaTypes(mediaTypes);
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(BigDecimal.class, ToStringSerializer.instance);
        getEnumTypes().stream().forEach(aClass -> {
            serializeConfig.put(aClass, (JSONSerializer serializer, Object object, Object fileName, Type type, int features) -> {
                SerializeWriter out = serializer.out;
                if(object instanceof Enumerator){
                    Enumerator enumerator = (Enumerator) object;
                    out.write(enumerator.getCode().toString());
                }else {
                    out.writeEnum((Enum<?>) object);
                }
            });
        });
        FastJsonConfig config = converter.getFastJsonConfig();
        config.setSerializeConfig(serializeConfig);
        converters.add(0, converter);
    }
    private static Set<Class<?>> getEnumTypes(){
        Set<Class<?>> classes = ClassScanner.scanPackage("com.henry.shop.common.base.enumerate");
        log.info("加载枚举包下所以枚举类成功，获取结果 = {}", JSON.toJSONString(classes));
        return classes;
    }
}
