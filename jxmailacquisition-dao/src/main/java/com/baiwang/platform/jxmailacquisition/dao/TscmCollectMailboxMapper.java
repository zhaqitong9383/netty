package com.baiwang.platform.jxmailacquisition.dao;

import com.baiwang.platform.jxmailacquisition.common.entity.TscmCollectMailbox;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 进项发票归集器，邮箱信息表 Mapper 接口
 * </p>
 *
 * @author shiqiang
 * @since 2020-04-29
 */
public interface TscmCollectMailboxMapper extends BaseMapper<TscmCollectMailbox> {
    List<TscmCollectMailbox> queryEmailByIdList(@Param("idList") List<Long> idList);
}
