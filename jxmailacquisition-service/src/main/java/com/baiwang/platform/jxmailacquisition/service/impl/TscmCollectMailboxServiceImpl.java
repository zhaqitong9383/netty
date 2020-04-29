package com.baiwang.platform.jxmailacquisition.service.impl;

import com.baiwang.platform.jxmailacquisition.common.entity.TscmCollectMailbox;
import com.baiwang.platform.jxmailacquisition.dao.TscmCollectMailboxMapper;
import com.baiwang.platform.jxmailacquisition.service.TscmCollectMailboxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 进项发票归集器，邮箱信息表 服务实现类
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-29
 */
@Service
public class TscmCollectMailboxServiceImpl extends ServiceImpl<TscmCollectMailboxMapper, TscmCollectMailbox> implements TscmCollectMailboxService {
    @Autowired
    private TscmCollectMailboxMapper tscmcollectMailboxMapper;

    @Override
    public List<TscmCollectMailbox> queryEmailByIdList(List<Long> idList) {
        List<TscmCollectMailbox> result = new ArrayList<>();
        try {
            if (CollectionUtils.isEmpty(idList)) return result;
            result = tscmcollectMailboxMapper.queryEmailByIdList(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
