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
 * 进项发票归集器，发票信息表
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollectorMailboxInvoice对象", description="进项发票归集器，发票信息表")
public class CollectorMailboxInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "进项发票归集器邮箱归集发票信息主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "采集邮箱id（外键，collect_mailbox主表id，主:子 1:N）")
    private Long collectMailboxId;

    @ApiModelProperty(value = "发票类型")
    private String invoiceType;

    @ApiModelProperty(value = "发票代码")
    private String invoiceCode;

    @ApiModelProperty(value = "发票号码")
    private String invoiceNo;

    @ApiModelProperty(value = "发票归集日期时间（不能为空，代码层面控制）")
    private Date invoiceCollectDatetime;

    @ApiModelProperty(value = "发票所有者")
    private String invoiceOwner;

    @ApiModelProperty(value = "发票附件")
    private String invoiceAttachments;

    @ApiModelProperty(value = "文件类型（该字段不能为空，1-pdf、2-ofd）")
    private Integer fileType;

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

    @ApiModelProperty(value = "自定义字段十一")
    private String def11;

    @ApiModelProperty(value = "自定义字段十二")
    private String def12;

    @ApiModelProperty(value = "自定义字段十三")
    private String def13;

    @ApiModelProperty(value = "自定义字段十四")
    private String def14;

    @ApiModelProperty(value = "自定义字段十五")
    private String def15;

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
