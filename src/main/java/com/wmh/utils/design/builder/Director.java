package com.wmh.utils.design.builder;

/**
 * @program: bill-admin-server
 * @description: 指挥者
 * @author: Mr.Hou
 * @create: 2020-12-15 14:48
 **/
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 产品构建组装方法
    public Product construce(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
