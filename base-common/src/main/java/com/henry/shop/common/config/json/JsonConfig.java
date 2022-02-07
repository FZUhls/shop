package com.henry.shop.common.config.json;

import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.henry.shop.common.base.enumerate.Enumerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * json序列化配置
 *
 * @author Henry
 */
@Slf4j
//@Configuration
public class JsonConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        List<MediaType> mediaTypes = getMediaType();
        converter.setSupportedMediaTypes(mediaTypes);
        SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
        ParserConfig parserConfig = ParserConfig.getGlobalInstance();
        //以下几种类型解析时解析为string，避免精度丢失
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
//        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(BigDecimal.class, ToStringSerializer.instance);
        //获取枚举包下所有枚举类
        Set<Class<?>> enumTypes = getEnumTypes();
        //为枚举类配置序列化和反序列化方法,只要实现Enumerator接口的枚举类都可以被fastjson正常序列化和反序列化
        enumTypes.stream().forEach(aClass -> {
            setEnumParser(aClass, parserConfig);
            setEnumSerializer(aClass, serializeConfig);
        });
        setLongDeserializer(parserConfig);
        //配置生效
        FastJsonConfig config = converter.getFastJsonConfig();
        config.setSerializeConfig(serializeConfig);
        config.setParserConfig(parserConfig);
        //将fastjson设置为序号为0的json解析器，同时要在pom中 exclude spring-boot-starter-json
        converters.add(0, converter);
    }

    /**
     * @return 获取 com.henry.shop.common.base.enumerate 包下的所有枚举类
     */
    private Set<Class<?>> getEnumTypes() {
        Set<Class<?>> classes = ClassScanner.scanPackage("com.henry.shop.common.base.enumerate");
        log.info("加载枚举包下所以枚举类成功，获取结果 = {}", JSON.toJSONString(classes));
        return classes;
    }

    /**
     * 为枚举配置序列化方法
     * @param aClass 枚举class
     * @param serializeConfig 序列化配置
     */
    private void setEnumSerializer(Class aClass, SerializeConfig serializeConfig) {
        serializeConfig.put(aClass, (JSONSerializer serializer, Object object, Object fileName, Type type, int features) -> {
            SerializeWriter out = serializer.out;
            if (object instanceof Enumerator) {
                Enumerator enumerator = (Enumerator) object;
                out.write(enumerator.getCode().toString());
            } else {
                out.writeEnum((Enum<?>) object);
            }
        });
    }
    private void setLongDeserializer(ParserConfig parserConfig){
        parserConfig.putDeserializer(Long.class, new ObjectDeserializer() {
            @Override
            public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
                Object parse = defaultJSONParser.parse();
                String string = parse.toString();
                if(Objects.isNull(string)){
                    log.error("JSON string = {}",string);
                    throw new JSONException("不能将空字符串转化为Long类型");
                }
                string = string.replace("\"","");
                string = string.replace("\'","");
                if(!StrUtil.isNumeric(string)){
                    log.error("JSON string = {}",string);
                    throw new JSONException("不能将非数字的字符串转为Long类型");
                }
                T t = (T) Long.valueOf(string);
                log.info("反序列化的结果是 : {}",t);
                return t;
            }

            @Override
            public int getFastMatchToken() {
                return 0;
            }
        });
    }

    /**
     * 为枚举配置反序列化方法
     * @param aClass 枚举class
     * @param parserConfig 反序列化方法
     */
    private void setEnumParser(Class aClass, ParserConfig parserConfig) {
        parserConfig.putDeserializer(aClass, new ObjectDeserializer() {
            @Override
            public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
                final JSONLexer lexer = parser.lexer;
                final int token = lexer.token();
                Class cls = (Class) type;
                Object[] enumConstants = cls.getEnumConstants();
                if (Enumerator.class.isAssignableFrom(cls)) {
                    for (Object enumConstant : enumConstants) {
                        Enumerator enumerator = (Enumerator) enumConstant;
                        Object enumCodeObject = enumerator.getCode();
                        int enumCode = Integer.parseInt(enumCodeObject.toString());
                        if (lexer.intValue() == enumCode) {
                            return (T) enumerator;
                        }
                    }
                } else {
                    //没实现EnumValue接口的 默认的按名字或者按ordinal
                    if (token == JSONToken.LITERAL_INT) {
                        int intValue = lexer.intValue();
                        lexer.nextToken(JSONToken.COMMA);
                        if (intValue < 0 || intValue > enumConstants.length) {
                            throw new JSONException(String.format("parse enum %s error, value : %s", cls.getName(), intValue));
                        }
                        return (T) enumConstants[intValue];
                    } else if (token == JSONToken.LITERAL_STRING) {
                        return (T) Enum.valueOf(cls, lexer.stringVal());
                    }
                }
                return null;
            }

            @Override
            public int getFastMatchToken() {
                return JSONToken.LITERAL_INT;
            }
        });
    }

    private List<MediaType> getMediaType(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        return mediaTypes;
    }
}
