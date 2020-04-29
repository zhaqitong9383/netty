package com.baiwang.platform.jxmailacquisition.common.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进项发票归集器，邮箱信息表
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TscmCollectMailbox对象", description="进项发票归集器，邮箱信息表")
public class TscmCollectMailbox implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "邮箱主键")
    @TableId(value = "ID", type = IdType.INPUT)
    private BigDecimal id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "机构id")
    private String orgId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "邮箱地址")
    private String emailAddress;

    @ApiModelProperty(value = "邮箱密码类型（1-密码、2-授权码）")
    private String passwordType;

    @ApiModelProperty(value = "邮箱密码（当邮箱类型为个人邮箱时，允许为空，企业邮箱该字段不能为空）")
    private String emailPassword;

    @ApiModelProperty(value = "邮箱类型（1-个人邮箱、2-企业邮箱）")
    private String mailNature;

    @ApiModelProperty(value = "上次归集日期时间")
    private Date lastCollectDate;

    @ApiModelProperty(value = "邮箱服务器")
    private String mailServer;

    @ApiModelProperty(value = "邮箱服务器端口号")
    private String mailPort;

    @ApiModelProperty(value = "邮箱服务器协议类型（1-pop3 、2-imap 、3-exchange）")
    private String mailProtocolType;

    @ApiModelProperty(value = "SSL开启标识（1-未开启ssl、2-开启ssl）")
    private String isSsl;

    @ApiModelProperty(value = "邮箱登录状态(1-登录成功、2-登录失败)")
    private String emailLoginState;

    @ApiModelProperty(value = "数据记录创建人（可以存创建人账号、用户名或用户id）")
    private String createBy;

    @ApiModelProperty(value = "数据记录创建时间")
    private Date createDate;

    @ApiModelProperty(value = "数据记录修改人")
    private String updateBy;

    @ApiModelProperty(value = "数据记录修改时间")
    private Date updateDate;

    @ApiModelProperty(value = "数据记录删除标识（0～false：未删除、1～true：已删除）")
    private String delFlag;

    @ApiModelProperty(value = "自定义字段一")
    private String ext1;

    @ApiModelProperty(value = "自定义字段二")
    private String ext2;

    @ApiModelProperty(value = "自定义字段三")
    private String ext3;

    @ApiModelProperty(value = "自定义字段四")
    private String ext4;

    @ApiModelProperty(value = "自定义字段五")
    private String ext5;

    @ApiModelProperty(value = "自定义字段六")
    private String ext6;

    @ApiModelProperty(value = "自定义字段七")
    private String ext7;

    @ApiModelProperty(value = "自定义字段八")
    private String ext8;

    @ApiModelProperty(value = "自定义字段九")
    private String ext9;

    @ApiModelProperty(value = "自定义字段十")
    private String ext10;


}
