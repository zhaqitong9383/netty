package com.netty.startup;

import com.baiwang.cloud.logaop.EnableBwLogAop;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.baiwang.platform", "com.baiwang.cloud"})
@MapperScan(basePackages = {"com.baiwang.platform.jxmailacquisition.dao"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.baiwang.platform.jxmailacquisition.integration"})
@EnableBwLogAop(proxyTargetClass = true)
public class NettyApplication {
    private static final Logger logger = LoggerFactory.getLogger(NettyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
        logger.info("\n\n\n\n\n                                                                                                                                   dddddddd\n" + "                          tttt                                                         tttt                                          d::::::d\n" + "                       ttt:::t                                                      ttt:::t                                          d::::::d\n" + "                       t:::::t                                                      t:::::t                                          d::::::d\n" + "                       t:::::t                                                      t:::::t                                          d:::::d \n" + "    ssssssssss   ttttttt:::::ttttttt      aaaaaaaaaaaaa   rrrrr   rrrrrrrrr   ttttttt:::::ttttttt        eeeeeeeeeeee        ddddddddd:::::d \n" + "  ss::::::::::s  t:::::::::::::::::t      a::::::::::::a  r::::rrr:::::::::r  t:::::::::::::::::t      ee::::::::::::ee    dd::::::::::::::d \n" + "ss:::::::::::::s t:::::::::::::::::t      aaaaaaaaa:::::a r:::::::::::::::::r t:::::::::::::::::t     e::::::eeeee:::::ee d::::::::::::::::d \n" + "s::::::ssss:::::stttttt:::::::tttttt               a::::a rr::::::rrrrr::::::rtttttt:::::::tttttt    e::::::e     e:::::ed:::::::ddddd:::::d \n" + " s:::::s  ssssss       t:::::t              aaaaaaa:::::a  r:::::r     r:::::r      t:::::t          e:::::::eeeee::::::ed::::::d    d:::::d \n" + "   s::::::s            t:::::t            aa::::::::::::a  r:::::r     rrrrrrr      t:::::t          e:::::::::::::::::e d:::::d     d:::::d \n" + "      s::::::s         t:::::t           a::::aaaa::::::a  r:::::r                  t:::::t          e::::::eeeeeeeeeee  d:::::d     d:::::d \n" + "ssssss   s:::::s       t:::::t    tttttta::::a    a:::::a  r:::::r                  t:::::t    tttttte:::::::e           d:::::d     d:::::d \n" + "s:::::ssss::::::s      t::::::tttt:::::ta::::a    a:::::a  r:::::r                  t::::::tttt:::::te::::::::e          d::::::ddddd::::::dd\n" + "s::::::::::::::s       tt::::::::::::::ta:::::aaaa::::::a  r:::::r                  tt::::::::::::::t e::::::::eeeeeeee   d:::::::::::::::::d\n" + " s:::::::::::ss          tt:::::::::::tt a::::::::::aa:::a r:::::r                    tt:::::::::::tt  ee:::::::::::::e    d:::::::::ddd::::d\n" + "  sssssssssss              ttttttttttt    aaaaaaaaaa  aaaa rrrrrrr                      ttttttttttt      eeeeeeeeeeeeee     ddddddddd   ddddd\n\n\n\n\n");
    }
}
