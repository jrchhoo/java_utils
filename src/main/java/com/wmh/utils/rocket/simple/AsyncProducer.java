package com.wmh.utils.rocket.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.CountDownLatch;

/**
 * @program: bill-admin-server
 * @description: 可靠异步传输
 * @author: Mr.Hou
 * @create: 2020-11-18 14:00
 **/
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        //实例化一个生产者组name
        DefaultMQProducer producer = new DefaultMQProducer("async_test_group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount  = 100;

        final CountDownLatch countDownLatch  = new CountDownLatch(messageCount);
        for (int i = 0; i < 100; i++) {
            final int index = 1;
            Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));

            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });

        }
        countDownLatch.await();
        producer.shutdown();
    }
}
