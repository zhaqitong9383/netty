package com.baiwang.platform.startup;

import com.baiwang.cloud.logaop.EnableBwLogAop;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"com.baiwang.platform","com.baiwang.cloud"})
@MapperScan(basePackages = {"com.baiwang.platform.dao"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.baiwang.platform.integration"})
@EnableBwLogAop(proxyTargetClass = true)
public class BwjxmailacquisitionApplication{

  public static void main(String[] args){
    SpringApplication.run(BwjxmailacquisitionApplication.class, args);
  }

}
