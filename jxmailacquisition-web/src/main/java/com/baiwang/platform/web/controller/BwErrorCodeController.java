package com.baiwang.platform.web.controller;

import com.baiwang.cloud.logaop.annotation.SystemServiceLog;
import com.baiwang.cloud.common.model.BWJsonResult;
import com.baiwang.platform.common.entity.BwErrorCode;
import com.baiwang.platform.service.BwErrorCodeServices;
import com.baiwang.platform.integration.SeqIntegration;
import com.baiwang.platform.service.BwErrorCodeServices;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Profile;
/**
 * <p>
 * 错误编码 前端控制器
 * </p>
 *
 * @author shiqiang
 * @since 2019-12-30
 */
@Profile({"default", "dev"})
@RestController
@Api("错误编码管理")
@RequestMapping("mytest/code")
public class BwErrorCodeController {
    @Autowired
    private BwErrorCodeServices codeServices;
    @Autowired
    private SeqIntegration seqIntegration;

    @ApiOperation(value = "测试一个用户",notes = "测试功能")
    @GetMapping(value = "/findone/{id}")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="id 查询")
    public BWJsonResult<BwErrorCode> test(@PathVariable("id") Long id ){
        return BWJsonResult.success(codeServices.getById(id));
    }


    @ApiOperation(value = "测试服务间调用",notes = "号码生成服务")
    @GetMapping(value = "/seq")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="取号获取")
    public BWJsonResult<Long> getSeq(){
        Long id = seqIntegration.getSeq();
        if(id == null){
            BWJsonResult.throwMsg("100","获取发号器失败");
        }
        return BWJsonResult.success(id);
    }
    @ApiOperation(value = "测试保存",notes = "保存记录")
    @PostMapping
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码保存")
    public BWJsonResult<Boolean> save(@RequestBody BwErrorCode errorCode){
        return BWJsonResult.success(codeServices.save(errorCode));
    }

    @ApiOperation(value = "测试更新",notes = "更新记录")
    @PutMapping
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码更新")
    public BWJsonResult<Boolean> updateOrSave(@RequestBody BwErrorCode errorCode){

        //一. UpdateWrapper 实现
        //如果errorcode 对象设置了对象字段字段，就会形成set 语句

        UpdateWrapper<BwErrorCode> codeWrapper = Wrappers.update();
        //更新code=‘test-100’ 的记录数据
        codeWrapper.eq("code","test-100");
        return BWJsonResult.success(codeServices.update(errorCode,codeWrapper));

        //一. LambdaUpdateWrapper 实现
       /* LambdaUpdateWrapper<BwErrorCode> lambdaUpdateWrapper = new LambdaUpdateWrapper();
        lambdaUpdateWrapper.eq(BwErrorCode::getCode,"test-100");
        return BWJsonResult.success(codeServices.update(errorCode,lambdaUpdateWrapper));*/
    }

    @ApiOperation(value = "测试自定义更新",notes = "更新记录")
    @PutMapping("custom")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码自定义更新")
    public BWJsonResult<Boolean> customUpdateOrSave(@RequestBody BwErrorCode errorCode){

        //一. UpdateWrapper 实现
        //如果errorcode 对象设置了对象字段字段，就会形成set 语句
        BwErrorCode code = new BwErrorCode();
        code.setMsg(errorCode.getMsg());
        code.setTechDescription(errorCode.getTechDescription());
        code.setOperatorsDescription("");//设置成空字符
        UpdateWrapper<BwErrorCode> codeWrapper = Wrappers.update();
        //更新code=‘test-100’ 的记录数据
        codeWrapper.eq("code","test-100");
        return BWJsonResult.success(codeServices.update(code,codeWrapper));

        //一. LambdaUpdateWrapper 实现
       /* LambdaUpdateWrapper<BwErrorCode> lambdaUpdateWrapper = new LambdaUpdateWrapper();
        lambdaUpdateWrapper.eq(BwErrorCode::getCode,"test-100");
        return BWJsonResult.success(codeServices.update(errorCode,lambdaUpdateWrapper));*/
    }

    //查询使用案例


    /*/**
     * @Author shiqi
     * @Description //根据 code 和 appName 去查询记录，且返回一条唯一记录
     * @Date 2020-01-08 16:31
     * @Param
     * @return
     **/
    @ApiOperation(value = "测试单条查询",notes = "查询记录")
    @PostMapping("one")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码单条查询")
    public BWJsonResult<BwErrorCode> queryOne(@RequestBody BwErrorCode errorCode){
        LambdaQueryWrapper<BwErrorCode> queryWrapper =  Wrappers.lambdaQuery();
        queryWrapper.eq(BwErrorCode::getCode,errorCode.getCode()).and(codeQuery->codeQuery.eq(BwErrorCode::getAppName,errorCode.getAppName()));
        return BWJsonResult.success(codeServices.getOne(queryWrapper));
    }

    @ApiOperation(value = "测试自定义分页多条查询",notes = "查询记录")
    @PostMapping("pagemore")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码分页查询")
    public BWJsonResult<BwErrorCode> queryPageMore(@RequestBody BwErrorCode errorCode){
        Page<BwErrorCode> page = new Page<>(1, 5);

        LambdaQueryWrapper<BwErrorCode> queryWrapper =  Wrappers.lambdaQuery();
        queryWrapper.eq(BwErrorCode::getAppName,errorCode.getAppName());
        IPage<BwErrorCode> mapIPage = codeServices.page(page,queryWrapper);
        return BWJsonResult.success(mapIPage.getRecords());
    }

    @ApiOperation(value = "测试多条查询",notes = "查询记录")
    @PostMapping("more")
    @SystemServiceLog(logType="controller",modelName="errorCode",businessCode="errorCode",action="错误码按应用名称查询")
    public BWJsonResult<BwErrorCode> queryMore(@RequestBody BwErrorCode errorCode){
        LambdaQueryWrapper<BwErrorCode> queryWrapper =  Wrappers.lambdaQuery();
        queryWrapper.eq(BwErrorCode::getAppName,errorCode.getAppName());
        return BWJsonResult.success(codeServices.list(queryWrapper));
    }

}
