package com.baiwang.platform.jxmailacquisition.config;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName TaskConsumer
 * @Author liting
 * @Date 2020/4/28 10:16
 */
@Slf4j
@Service
public class TaskConsumer implements MessageListener {

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        try {
            String msg = new String(message.getBody());//获取到接收的消息，由于接收到的是byte数组，所以需要转换成字符串
            log.info("获取任务消费数据：{}，tag：{},msgId:{}", msg, message.getTag(), message.getMsgID());
            return Action.CommitMessage;
        }catch (Exception e){
            e.printStackTrace();
            log.error("任务消费异常={}",e.getMessage());
        }
        return Action.ReconsumeLater;
    }
}
