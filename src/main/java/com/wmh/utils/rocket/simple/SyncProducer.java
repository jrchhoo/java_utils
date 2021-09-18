package com.wmh.utils.rocket.simple;


import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @program: bill-admin-client
 * @description: 可靠同步消息生产者
 * @author: Mr.Hou
 * @create: 2020-11-17 10:36
 **/
public class SyncProducer {

    public static void main(String[] args) throws Exception {

        // 实例化生产者组name
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("simple_sync_producer");
        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQProducer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicTest", "TagA", ("HelloMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = defaultMQProducer.send(message);
            System.out.printf("%s%n", sendResult);
        }
        defaultMQProducer.shutdown();

    }
}
