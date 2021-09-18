package com.wmh.utils.design.prototype;

/**
 * @program: bill-admin-server
 * @description: 原型模式
 *          以一个已经创建的实例作为原型，通过复制该对象创建一个近似的新对象，用于对象复制
 *          基于二进制流的复制，比new性能优良，深克隆保存对象状态
 *          假设有多个对象，对象属性大部分相同时，可采用原型模式设计获取新对象
 * @author: Mr.Hou
 * @create: 2020-12-04 10:06
 **/
public class RealizeType implements Cloneable {

    RealizeType(){
        System.out.println("创建原型类");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (RealizeType) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        RealizeType type1 = new RealizeType();
        RealizeType type2 = (RealizeType) type1.clone();
        System.out.println("type1 == type2:" + (type1 == type2));
    }
}
