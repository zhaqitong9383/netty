package com.baiwang.platform.jxmailacquisition.web.controller;

import com.alibaba.fastjson.JSON;
import com.baiwang.cloud.common.model.BWJsonResult;
import com.baiwang.cloud.logaop.annotation.SystemServiceLog;
import com.baiwang.platform.jxmailacquisition.common.entity.CollectMailbox;
import com.baiwang.platform.jxmailacquisition.service.CollectMailboxServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Profile({"default", "dev"})
@Api("发票采集/邮箱采集/企业邮箱管理")
@RequestMapping("enterpriseMailbox")
@RestController
public class EnterpriseMailboxController {
    @Autowired
    private CollectMailboxServices collectMailboxServices;

    @PostMapping("addEmail")
    @ApiOperation(value = "添加一个企业邮箱", notes = "添加功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "addEmail", action = "添加企业邮箱")
    public BWJsonResult<Void> addEmail(@RequestBody CollectMailbox collectMailbox) {
        return null;
    }

    @RequestMapping("delEmailById/{id}")
    @ApiOperation(value = "根据id删除一个企业邮箱", notes = "删除功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "delEmail", action = "删除企业邮箱信息")
    public BWJsonResult<Void> delEmailById(@PathVariable("id") Long id) {
        return null;
    }

    @RequestMapping("editEmail")
    @ApiOperation(value = "编辑一个企业邮箱", notes = "修改功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "editEmail", action = "编辑企业邮箱信息")
    public BWJsonResult<Void> editEmail(@RequestBody CollectMailbox collectMailbox) {
        return null;
    }

    @PostMapping("queryEmail")
    @ApiOperation(value = "根据条件查询企业邮箱", notes = "查询功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "queryEmail", action = "查询企业邮箱信息")
    public BWJsonResult<List<CollectMailbox>> queryEmail(@RequestBody CollectMailbox collectMailbox) {
        return null;
    }

    @GetMapping("queryEmailById/{id}")
    @ApiOperation(value = "根据id查询企业邮箱详细信息", notes = "查询功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "queryEmailById", action = "根据id查询企业邮箱信息详细信息")
    public BWJsonResult<CollectMailbox> queryEmailById(@PathVariable("id") Long id) {
        log.info("根据id查询企业邮箱详细信息，请求入参id='{}'", id);
        CollectMailbox result = collectMailboxServices.getById(id);
        BWJsonResult<CollectMailbox> bwJsonResult = BWJsonResult.success(result, "查询成功");
        log.info("根据id查询企业邮箱详细信息返回值：【{}】", JSON.toJSONString(bwJsonResult));
        return bwJsonResult;
    }

    /**
     * 自定义Mapper样例
     *
     * @param idString
     * @return
     */
    @GetMapping("queryEmailByIdString/{idString}")
    public BWJsonResult<List<CollectMailbox>> queryEmailByIdString(@PathVariable("idString") String idString) {
        List<Long> idList = Arrays.stream(StringUtils.split(idString, ",")).map(el -> Long.valueOf(el)).collect(Collectors.toList());
        List<CollectMailbox> result = collectMailboxServices.queryEmailByIdList(idList);
        BWJsonResult<List<CollectMailbox>> bwJsonResult = new BWJsonResult(result);
        bwJsonResult.setSuccess(true);
        bwJsonResult.setTotal(result.size());
        bwJsonResult.setMessage("查询成功");
        return bwJsonResult;
    }
}
