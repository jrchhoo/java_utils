package com.wmh.utils.design.builder;

/**
 * @program: bill-admin-server
 * @description: 抽象建造者
 * @author: Mr.Hou
 * @create: 2020-12-15 14:45
 **/
public abstract class Builder {

    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getResult(){
        return product;
    }
}
