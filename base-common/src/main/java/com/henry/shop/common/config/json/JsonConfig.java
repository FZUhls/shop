package com.henry.shop.common.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.henry.shop.common.base.enumerate.Enumerator;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * json序列号器配置
 * @author Henry
 */
@Configuration
public class JsonConfig {
    @Resource
    ObjectMapper objectMapper;
    @PostConstruct
    public void objectMapper(){
        // 声明一个简单Module 对象
        SimpleModule module = new SimpleModule();
        // 给Module 添加一个序列化器
        module.addSerializer(Enumerator.class, new JsonSerializer<Enumerator>() {
            @Override
            public void serialize(Enumerator value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeNumber(value.getCode());
            }
        });
        // 注册 Module
        objectMapper.registerModule(module);
    }
}
