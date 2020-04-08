package com.baiwang.platform.jxmailacquisition.integration.impl;

import com.alibaba.fastjson.JSONObject;
import com.baiwang.platform.jxmailacquisition.integration.SeqIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shiqiang on 2018/6/27.
 */
@Component
@Slf4j
public class SeqIntegrationImpl implements SeqIntegration {
//    @Autowired
//    private IdService idService;

    @Override
    public Long getSeq() {
//        Long id = idService.genId();
//        return id;
        log.error("获取号码成错误");
        return null;
    }

    @Override
    public JSONObject getBatchSeq(Long num) {
        return null;
    }
}
