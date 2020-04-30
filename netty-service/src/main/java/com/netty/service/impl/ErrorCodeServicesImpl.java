package com.netty.service.impl;

import com.netty.common.entity.ErrorCode;
import com.netty.dao.ErrorCodeMapper;
import com.netty.service.ErrorCodeServices;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
@DS("slave2")
public class ErrorCodeServicesImpl extends ServiceImpl<ErrorCodeMapper, ErrorCode> implements ErrorCodeServices {

}
