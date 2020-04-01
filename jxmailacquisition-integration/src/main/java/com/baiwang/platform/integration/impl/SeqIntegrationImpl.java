package com.baiwang.platform.integration.impl;
import com.alibaba.fastjson.JSONObject;
import com.baiwang.platform.integration.SeqIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * Created by shiqiang on 2018/6/27.
 */
@Component
@Slf4j
public class SeqIntegrationImpl implements SeqIntegration {
/*    @Autowired
    private IdService idService;*/
    public Long getSeq(){
      /*  Long id = idService.genId();
        return id;*/
      log.error("获取号码成错误");

      return null;
    }
    public JSONObject getBatchSeq(Long num){
      return null;
    }
}
