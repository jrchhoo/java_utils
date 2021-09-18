package com.wmh.utils.design.single;

/**
 * @program: bill-admin-server
 * @description: 饿汉式单例应用
 * @author: Mr.Hou
 * @create: 2020-12-04 09:52
 **/
public class HungrySingletonDemo {

    public static void main(String[] args) {
        Bajie bajie1 = Bajie.getInstance();
        bajie1.getName();

        Bajie bajie2 = Bajie.getInstance();
        bajie2.getName();

        if (bajie1 == bajie2) {
            System.out.println("八戒还是那个八戒");
        } else {
            System.out.println("另一个八戒");
        }
    }

}

class Bajie {

    private static Bajie bajie = new Bajie();

    private Bajie(){
        System.out.println("我是八戒");
    }

    public static Bajie getInstance(){
        return bajie;
    }

    public void getName(){
        System.out.println("我是八戒：猴哥是我大师兄");
    }
}
