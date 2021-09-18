package com.wmh.utils.design.proxy;

/**
 * @program: bill-admin-server
 * @description: 代理模式2
 * @author: Mr.Hou
 * @create: 2021-05-20 14:02
 **/
public class StaticProxy2Demo {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("123456789");
    }

}

/**
 * 发送短信的接口
 */
interface SmsService{
    String send(String message);
}

/**
 * 实现发送短信的接口
 */
class SmsServiceImpl implements SmsService{

    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}

class SmsProxy implements SmsService{

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("发送之前的方法");
        smsService.send(message);
        System.out.println("发送之后的方法");
        return null;
    }
}
