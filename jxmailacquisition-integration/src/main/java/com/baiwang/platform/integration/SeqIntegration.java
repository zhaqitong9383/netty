package com.baiwang.platform.integration;
import com.alibaba.fastjson.JSONObject;
import com.baiwang.platform.integration.impl.SeqServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shiqiang on 2018/6/27.
 *
 * ID的序列生成器
 */
@FeignClient(value = "vesta-services",fallbackFactory = SeqServiceFallback.class)
public interface SeqIntegration {
    @RequestMapping(value = "/seq", method = RequestMethod.GET)
    public Long getSeq();


    @RequestMapping(value = "/seq/{num}", method = RequestMethod.GET)
    public JSONObject getBatchSeq(@PathVariable("num") Long num);
}