package com.wmh.utils.design.proxy;//package com.wmhou.demo.design.proxy;
//
//
//
///**
// * @program: bill-admin-server
// * @description: 代理模式
// * @author: Mr.Hou
// * @create: 2020-12-15 15:24
// **/
//public class ProxyDemo {
//
//    public static void main(String[] args) {
//        Proxy proxy = new Proxy();
//        proxy.request();
//
//    }
//}
//
///**
// * 抽象主题
// */
//interface Subject{
//    void request();
//}
//
//class RealSubject implements Subject{
//
//    @Override
//    public void request() {
//        System.out.println("访问真实主题方法*******");
//    }
//}
//
//class Proxy implements Subject{
//
//    private RealSubject realSubject;
//
//    @Override
//    public void request() {
//        if (realSubject == null) {
//            realSubject = new RealSubject();
//        }
//        preRequest();
//        realSubject.request();
//        postRequest();
//    }
//
//    public void preRequest(){
//        System.out.println("访问真实主题之前的方法");
//    }
//
//    public void postRequest(){
//        System.out.println("访问真实主题后的处理-------");
//    }
//}