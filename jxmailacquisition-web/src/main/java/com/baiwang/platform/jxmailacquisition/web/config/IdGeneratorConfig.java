package com.baiwang.platform.jxmailacquisition.web.config;

import com.baiwang.platform.jxmailacquisition.service.impl.CustomIdGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: IdGeneratorConfig
 * @description: TODO
 * @author: shiqiang
 * @create: 2020-03-24 16:19
 **/
@Configuration
public class IdGeneratorConfig {
    @Bean
    @ConditionalOnProperty(prefix = "myself", name = "id", havingValue = "true", matchIfMissing = true)
    public IdentifierGenerator idGenerator() {
        return new CustomIdGenerator();
    }
}
