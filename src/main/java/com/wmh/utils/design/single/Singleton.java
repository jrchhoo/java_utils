package com.wmh.utils.design.single;

/**
 * @program: bill-admin-server
 * @description: 饿汉式单例模式
 *          懒汉式单例：
 *              使用时加载，相对不占用内存资源，但是式线程不安全的，需要同步修饰；
 *          饿汉式单例：
 *              初始化时加载，占用内存资源，但是线程安全的；
 * @author: Mr.Hou
 * @create: 2020-12-03 10:55
 **/
public class Singleton {

}

/**
 * @program: bill-admin-server
 * @description: 饿汉式单例模式
 * @author: Mr.Hou
 * @create: 2020-12-03 10:55
 **/
class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }


    public static void main(String[] args) {
        HungrySingleton.getInstance();
    }
}


/**
 * @program: bill-admin-server
 * @description: 懒汉式单例模式
 * @author: Mr.Hou
 * @create: 2020-12-03 10:55
 **/
class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance() {
        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
    public static void main(String[] args) {
        LazySingleton.getInstance();
    }


}
