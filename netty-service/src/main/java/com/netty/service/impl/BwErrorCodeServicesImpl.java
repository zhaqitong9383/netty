package com.netty.service.impl;

import com.netty.common.entity.ErrorCode;
import com.netty.dao.ErrorCodeMapper;
import com.netty.service.BwErrorCodeServices;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 错误编码 服务实现类
 * </p>
 *
 * @author shiqiang
 * @since 2019-12-31
 */
@Service
@DS("slave2")
public class BwErrorCodeServicesImpl extends ServiceImpl<ErrorCodeMapper, ErrorCode> implements BwErrorCodeServices {

}
