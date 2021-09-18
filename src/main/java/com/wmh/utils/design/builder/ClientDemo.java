package com.wmh.utils.design.builder;

/**
 * @program: bill-admin-server
 * @description: 客户类
 * @author: Mr.Hou
 * @create: 2020-12-15 14:50
 **/
public class ClientDemo {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construce();
        product.show();
    }
}
