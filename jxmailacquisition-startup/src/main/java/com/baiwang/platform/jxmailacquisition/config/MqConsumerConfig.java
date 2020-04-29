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

    @Value("${mailacquisition.mq.consumer.groupId}")
    private String groupId;

    @Value("${mailacquisition.mq.consumer.accessKey}")
    private String accessKey;

    @Value("${mailacquisition.mq.consumer.secretKey}")
    private String secretKey;

    @Value("${mailacquisition.mq.consumer.onsAddr}")
    private String onsAddr;

    @Value("${mailacquisition.mq.consumer.topic}")
    private String topic;

    @Value("${mailacquisition.mq.consumer.tag}")
    private String tag;

    @Value("${mailacquisition.mq.consumer.maxReconsumeTimes}")
    private String maxReconsumeTimes;

    @Value("${mailacquisition.mq.consumer.consumeThreadNums}")
    private String consumeThreadNums;

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
        properties.setProperty(PropertyKeyConst.GROUP_ID, groupId);
        properties.setProperty(PropertyKeyConst.AccessKey, accessKey);
        properties.setProperty(PropertyKeyConst.SecretKey, secretKey);
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, onsAddr);
        // 消息处理失败后多久重新拉取消息
//        properties.put(PropertyKeyConst.SuspendTimeMillis, suspendTimeMillis);
        // 消息消费失败时的最大重试次数
        properties.put(PropertyKeyConst.MaxReconsumeTimes, maxReconsumeTimes);
        // 消费线程数
        properties.put(PropertyKeyConst.ConsumeThreadNums, consumeThreadNums);
        consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(topic, tag, taskConsumer);
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
