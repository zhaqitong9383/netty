package com.baiwang.platform.jxmailacquisition.service;

import com.baiwang.platform.jxmailacquisition.common.entity.TscmCollectMailbox;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 进项发票归集器，邮箱信息表 服务类
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-29
 */
public interface TscmCollectMailboxService extends IService<TscmCollectMailbox> {
    List<TscmCollectMailbox> queryEmailByIdList(List<Long> idList);
}
