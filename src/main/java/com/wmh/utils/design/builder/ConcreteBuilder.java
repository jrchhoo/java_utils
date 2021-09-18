package com.wmh.utils.design.builder;

/**
 * @program: bill-admin-server
 * @description: 具体建造者
 * @author: Mr.Hou
 * @create: 2020-12-15 14:47
 **/
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        System.out.println("建造:partA");
    }

    @Override
    public void buildPartB() {
        System.out.println("建造:partB");
    }

    @Override
    public void buildPartC() {
        System.out.println("建造:partC");
    }
}
