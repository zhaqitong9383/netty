package com.baiwang.platform.jxmailacquisition.integration;

import com.baiwang.invoice.collect.api.controller.EmailCollectApi;
import com.baiwang.invoice.collect.api.dto.CreateTaskDto;
import com.baiwang.invoice.collect.api.dto.EmailCheckDto;
import com.baiwang.invoice.collect.api.dto.EmailConfigDto;
import com.baiwang.invoice.collect.api.vo.CreateTaskVo;
import com.baiwang.invoice.collect.api.vo.EmailCheckVo;
import com.baiwang.invoice.collect.api.vo.EmailConfigVo;
import com.baiwang.moirai.model.common.BWJsonResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * All rights Reserved, Designed By www.baiwang.com
 *
 * @version v1.0
 * @author: 大客户技术部  liting
 * @date: 2020/4/29 09:23
 * @Copyright: 2020 www.baiwang.com Inc. All rights reserved. 注意：本内容仅限于百望股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(value = "invoice-collect-service")
public interface EmailCollectIntegration extends EmailCollectApi {
    // 邮件验证
    @RequestMapping(value = {"/mail/check"}, method = {RequestMethod.POST})
    BWJsonResult<EmailCheckVo> emailCheck(@RequestBody EmailCheckDto emailCheckDto);

    // 邮件server配置查询
    @RequestMapping(value = {"/mail/serverQuery"}, method = {RequestMethod.POST})
    BWJsonResult<EmailConfigVo> serverQuery(@RequestBody EmailConfigDto emailConfigDto);

    // 邮件发票抽取
    @RequestMapping(value = {"/mail/spiderMail"}, method = {RequestMethod.POST})
    BWJsonResult<CreateTaskVo> createTask(@RequestBody CreateTaskDto createTaskDto);
}
