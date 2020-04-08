package com.baiwang.platform.jxmailacquisition.web.controller;

import com.baiwang.cloud.common.model.BWJsonResult;
import com.baiwang.cloud.logaop.annotation.SystemServiceLog;
import com.baiwang.platform.jxmailacquisition.common.entity.BwErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile({"default", "dev"})
@Api("发票采集/邮箱采集/个人邮箱管理")
@RequestMapping("personalMailbox")
@RestController
public class PersonalMailboxController {
    @PostMapping("addEmail")
    @ApiOperation(value = "添加一个个人邮箱", notes = "添加功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "addEmail", action = "添加个人邮箱")
    public BWJsonResult<BwErrorCode> addEmail() {
        return null;
    }

    @PostMapping("delEmail")
    @ApiOperation(value = "删除一个个人邮箱", notes = "删除功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "delEmail", action = "删除个人邮箱信息")
    public BWJsonResult<BwErrorCode> delEmail() {
        return null;
    }

    @PostMapping("editEmail")
    @ApiOperation(value = "编辑一个个人邮箱", notes = "修改功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "editEmail", action = "编辑个人邮箱信息")
    public BWJsonResult<BwErrorCode> editEmail() {
        return null;
    }

    @PostMapping("queryEmail")
    @ApiOperation(value = "根据条件查询个人邮箱", notes = "查询功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "queryEmail", action = "查询个人邮箱信息")
    public BWJsonResult<BwErrorCode> queryEmail() {
        return null;
    }

    @PostMapping("queryEmailById")
    @ApiOperation(value = "根据id查询个人邮箱详细信息", notes = "查询功能")
    @SystemServiceLog(logType = "controller", modelName = "邮箱归集", businessCode = "queryEmailById", action = "根据id查询个人邮箱信息详细信息")
    public BWJsonResult<BwErrorCode> queryEmailById() {
        return null;
    }

}
