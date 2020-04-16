package com.baiwang.platform.jxmailacquisition.service;

import com.baiwang.platform.jxmailacquisition.common.entity.CollectMailbox;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 进项发票归集器，邮箱信息表 服务类
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-16
 */
public interface CollectMailboxServices extends IService<CollectMailbox> {
    List<CollectMailbox> queryEmailByIdList(List<Long> idList);
}
