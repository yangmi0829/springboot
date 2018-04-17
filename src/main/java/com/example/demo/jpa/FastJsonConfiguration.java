package com.example.demo.jpa;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /*调用父类的配置*/
        super.configureMessageConverters(converters);
        /*创建fastJson消息转换器*/
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        /*创建配置类*/
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        /*修改配置返回内容的过滤*/
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,//消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        /*将fastJson添加到试图消息转换器列表内*/
        converters.add(fastJsonHttpMessageConverter);
    }

}

