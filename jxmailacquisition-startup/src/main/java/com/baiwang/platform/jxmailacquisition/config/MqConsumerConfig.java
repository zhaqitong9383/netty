package com.baiwang.platform.jxmailacquisition.config;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @ClassName MqConsumerConfig
 * @Description 消息队列消费者配置
 * @Author liting
 * @Date 2020/4/28 15:25
 */
@Component
@Slf4j
public class MqConsumerConfig implements CommandLineRunner {

    @Value("${rocketmq.consumer.email.result.receiveGId}")
    private String gid;

    @Value("${rocketmq.consumer.accessKey}")
    private String accessKey;

    @Value("${rocketmq.consumer.secretKey}")
    private String secretKey;

    @Value("${rocketmq.consumer.onsAddr}")
    private String onsAdress;

    @Value("${rocketmq.consumer.email.result.receiveTopic}")
    private String msgTopic;
    @Value("${rocketmq.consumer.email.result.receiveTag}")
    private String receiveTag;

    private Consumer consumer;

    @Value("${usemq.flag}")
    private boolean useMqFlag;

    @Autowired
    private TaskConsumer taskConsumer;

    @Override
    public void run(String... args) throws Exception {
        if(useMqFlag) {
            this.init();
        }
    }

    public void init(){
        log.info("初始化启动消费者！");
        // consumer 实例配置初始化
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.GROUP_ID, gid);
        properties.setProperty(PropertyKeyConst.AccessKey, accessKey);
        properties.setProperty(PropertyKeyConst.SecretKey, secretKey);
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, onsAdress);
        consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(msgTopic, receiveTag, taskConsumer);
        consumer.start();
        if(!consumer.isStarted()){
            consumer.start();
        }
        log.info("消费者 start success."+consumer.isStarted());

    }

    /**
     * 初始化消费者
     * @return
     */
    public Consumer getConsumer(){
        return consumer;
    }
}
