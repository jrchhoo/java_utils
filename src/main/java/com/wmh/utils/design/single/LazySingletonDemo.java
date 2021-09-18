package com.wmh.utils.design.single;

/**
 * @program: bill-admin-server
 * @description: 单例模式应用demo
 * @author: Mr.Hou
 * @create: 2020-12-04 09:44
 **/
public class LazySingletonDemo {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        president1.getName();

        President president2 = President.getInstance();
        president2.getName();

        if (president1 == president2) {
            System.out.println("这是同一个人");
        } else {
            System.out.println("不同的人");
        }
    }

}

class President{

    private static volatile President instance = null;

    private President(){
        System.out.println("产生一个总统");
    }

    public static synchronized President getInstance(){
        if (instance == null) {
            instance = new President();
        } else {
            System.out.println("已经有一个总统，不能产生新总统");
        }
        return instance;
    }

    public void getName(){
        System.out.println("我是美国总统：川建国");
    }
}
