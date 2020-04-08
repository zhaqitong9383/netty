package com.baiwang.platform.jxmailacquisition.dao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: MybatisPlusConfig
 * @description: TODO
 * @author: shiqiang
 * @create: 2020-01-08 17:09
 **/
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    @Getter
    @Setter
    @Value("${mybatis.plus.pageSize:500}")
    private Integer pageSize;

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 count 的 join 优化,只针对 left join !!!
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        //设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(pageSize);
        return paginationInterceptor;
    }
}
