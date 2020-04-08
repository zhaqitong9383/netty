package com.baiwang.platform.jxmailacquisition.service.impl;

import com.baiwang.platform.jxmailacquisition.common.entity.CollectMailbox;
import com.baiwang.platform.jxmailacquisition.dao.CollectMailboxMapper;
import com.baiwang.platform.jxmailacquisition.service.CollectMailboxServices;
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
 * @since 2020-04-08
 */
@Service
public class CollectMailboxServicesImpl extends ServiceImpl<CollectMailboxMapper, CollectMailbox> implements CollectMailboxServices {
    @Autowired
    private CollectMailboxMapper collectMailboxMapper;

    @Override
    public List<CollectMailbox> queryEmailByIdList(List<Long> idList) {
        List<CollectMailbox> result = new ArrayList<>();
        try {
            if (CollectionUtils.isEmpty(idList)) return result;
            result = collectMailboxMapper.queryEmailByIdList(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
