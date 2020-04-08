package com.baiwang.platform.jxmailacquisition.common.entity;

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
 * @since 2020-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollectMailbox对象", description="进项发票归集器，邮箱信息表")
public class CollectMailbox implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "归集邮箱主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "租户id（不能为空，代码层面控制）")
    private Long tenantId;

    @ApiModelProperty(value = "机构id（不能为空，代码层面控制）")
    private Long orgId;

    @ApiModelProperty(value = "用户id（不能为空，代码层面控制）")
    private Long userId;

    @ApiModelProperty(value = "邮箱地址（不能为空且必须是邮箱格式，代码层面控制）")
    private String emailAddress;

    @ApiModelProperty(value = "邮箱密码（秘文）")
    private String emailPassword;

    @ApiModelProperty(value = "邮箱添加人用户名（不能为空，代码层面控制）")
    private String emailAddUsername;

    @ApiModelProperty(value = "邮箱添加日期时间（不能为空，代码层面控制）")
    private Date emailAddDatetime;

    @ApiModelProperty(value = "邮箱类型（1～true-企业邮箱、0～false-个人邮箱，Defaults：1）")
    private Boolean enterpriseMailbox;

    @ApiModelProperty(value = "上次登录人")
    private String lastLoginUsername;

    @ApiModelProperty(value = "上次登录日期时间")
    private Date lastLoginDatetime;

    @ApiModelProperty(value = "上次归集日期时间（上次从邮箱归集发票的时间，不能为空，代码层面控制）")
    private Date lastCollectDatetime;

    @ApiModelProperty(value = "自定义字段一")
    private String def1;

    @ApiModelProperty(value = "自定义字段二")
    private String def2;

    @ApiModelProperty(value = "自定义字段三")
    private String def3;

    @ApiModelProperty(value = "自定义字段四")
    private String def4;

    @ApiModelProperty(value = "自定义字段五")
    private String def5;

    @ApiModelProperty(value = "自定义字段六")
    private String def6;

    @ApiModelProperty(value = "自定义字段七")
    private String def7;

    @ApiModelProperty(value = "自定义字段八")
    private String def8;

    @ApiModelProperty(value = "自定义字段九")
    private String def9;

    @ApiModelProperty(value = "自定义字段十")
    private String def10;

    @ApiModelProperty(value = "数据记录创建人（可以存创建人账号、用户名或用户id）")
    private String creater;

    @ApiModelProperty(value = "数据记录创建时间（该字段不能为空，数据库层面不做控制交由代码层控制）")
    private Date createDatetime;

    @ApiModelProperty(value = "数据记录修改人（可以存修改人账号、用户名或用户id）")
    private String modifyUser;

    @ApiModelProperty(value = "数据记录修改时间（该字段不能为空，数据库层面不做控制交由代码层控制）")
    private Date modifyDatetime;

    @ApiModelProperty(value = "数据记录已删除标识（0～false：未删除、1～true：已删除，默认为0）")
    private Boolean deleted;


}
