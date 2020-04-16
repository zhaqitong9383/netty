package com.baiwang.platform.jxmailacquisition.dao;

import com.baiwang.platform.jxmailacquisition.common.entity.CollectMailbox;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 进项发票归集器，邮箱信息表 Mapper 接口
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-16
 */
public interface CollectMailboxMapper extends BaseMapper<CollectMailbox> {
    List<CollectMailbox> queryEmailByIdList(@Param("idList") List<Long> idList);
}
