package com.baiwang.platform.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 错误编码
 * </p>
 *
 * @author shiqiang
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bw_error_code")
@ApiModel(value="BwErrorCode对象", description="错误编码")
public class BwErrorCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "系统名称")
    private String appName;

    @ApiModelProperty(value = "编码错误提示")
    private String msg;

    @ApiModelProperty(value = "技术排查说明")
    private String techDescription;

    @ApiModelProperty(value = "运营处理说明")
    private String operatorsDescription;

    @ApiModelProperty(value = "是否告警")
    private Boolean isWarning;

    @ApiModelProperty(value = "错误编码等级:1 一级 2 二级 3 三级")
    private String codeLevel;

    @ApiModelProperty(value = "创建时间")
    @JSONField(format = "yyyy-MM-dd")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JSONField(format = "yyyy-MM-dd")
    private LocalDateTime updateTime;


}
