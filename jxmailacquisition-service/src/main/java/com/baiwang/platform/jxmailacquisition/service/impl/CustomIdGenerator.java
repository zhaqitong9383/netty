package com.baiwang.platform.jxmailacquisition.service.impl;

import cn.hutool.core.lang.Assert;
import com.baiwang.platform.jxmailacquisition.integration.SeqIntegration;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: CustomIdGenerator
 * @description: TODO
 * @author: shiqiang
 * @create: 2020-03-24 14:31
 **/
@Slf4j
public class CustomIdGenerator implements IdentifierGenerator {
    @Autowired
    private SeqIntegration seqIntegration;

    @Override
    public Number nextId(Object entity) {
//        可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
//        String bizKey = entity.getClass().getName();
//        log.info("业务类型{}",bizKey);
//        根据bizKey调用分布式ID生成
        Long id = seqIntegration.getSeq();
        Assert.notNull(id, "生成主键id不能为空！");
        return id;
    }
}
