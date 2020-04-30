package com.netty.integration.impl;

import com.alibaba.fastjson.JSONObject;
import com.netty.integration.SeqIntegration;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @program: SeqServiceFallback
 * @description: TODO
 * @author: shiqiang
 * @create: 2020-01-06 15:18
 **/
@Slf4j
@Component
public class SeqServiceFallback implements FallbackFactory<SeqIntegration> {
    @Override
    public SeqIntegration create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();
        if (!StringUtils.isEmpty(msg)) {
            log.error(msg, throwable);
        }

        return new SeqIntegration() {
            @Override
            public Long getSeq() {
                return null;
            }

            @Override
            public JSONObject getBatchSeq(Long num) {
                return null;
            }
        };
    }
}
