package com.baiwang.platform.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;


/*/**
 * @Author shiqi
 * @Description //TODO
 * @Date 2020-01-13 19:27
 * @Param
 * @return
 **/
@Configuration
@Data
public class FastJsonConfiguration {
    @Value("${spring.json.formart:yyyy-MM-dd HH:mm:ss}")
    private String dateFormat = "yyyy-MM-dd HH:mm:ss";
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, new MediaType("application", "*+json")));
        FastJsonConfig fastJsonConfig = getFastJsonConfig();
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return fastJsonHttpMessageConverter;
    }

    private FastJsonConfig getFastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        String dateFormat = getDateFormat();
        if (StringUtils.isNotBlank(dateFormat)) {
            try {
                DateFormatUtils.format(new Date(), dateFormat);
            } catch (Exception e) {
                throw new IllegalArgumentException(
                        String.format("spring.mvc.date-format配置的日志格式：%s，不正确！", dateFormat), e);
            }
            JSON.DEFFAULT_DATE_FORMAT = dateFormat;
        }
        //fastJsonConfig.setDateFormat(..)的优先级会高于字段上的@JSONField主键中配置的format
        //因此这里不能进行配置
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat
        );
        //输出long为字符串
        fastJsonConfig.setSerializeFilters(new ValueFilter() {
            @Override
            public Object process(Object object, String name, Object value) {
                if (value instanceof Long) {
                    return String.valueOf(value);
                } /*else if (value instanceof LocalDateTime){
                    value = ((LocalDateTime) value).format(DateTimeFormatter.ofPattern(dateFormat));
                }*/
                return value;
            }
        });
        return fastJsonConfig;
    }
}
