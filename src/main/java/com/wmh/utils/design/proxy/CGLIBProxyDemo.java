package com.wmh.utils.design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: bill-admin-server
 * @description: CGLIB代理实例
 * @author: Mr.Hou
 * @create: 2021-05-20 14:40
 **/
public class CGLIBProxyDemo {

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");

        TencentSmsService tencentSmsService = (TencentSmsService) CglibProxyFactory.getProxy(TencentSmsService.class);
        tencentSmsService.send("c++");
    }
}


class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

class TencentSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}


class DebugMethodInteceptor implements MethodInterceptor{
    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj    "this", the enhanced object
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @see MethodProxy
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("之前: " + method.getName());
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("之后: " + method.getName());
        return object;
    }
}


class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInteceptor());
        // 创建代理类
        return enhancer.create();
    }
}