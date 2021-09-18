package com.wmh.utils.design.factorymethod;

import lombok.Data;

/**
 * @program: bill-admin-server
 * @description: 工厂方法模式
 * @author: Mr.Hou
 * @create: 2020-12-04 10:52
 **/
public class FactoryMethod {
}

/**
 * 抽象产品
 */
@Data
abstract class Car{
    private String name;
    public abstract void drive();
}

/**
 * 具体产品
 */
class Benz extends Car{

    @Override
    public void drive() {
        System.out.println(this.getName() + "GO");
    }
}

class Bmw extends Car{

    @Override
    public void drive() {
        System.out.println(this.getName() + "GO");
    }
}

/**
 * 抽象工厂
 */
abstract class Factory{
    public abstract Car createCar(String car) throws Exception;
}


/**
 * 具体工厂
 */
class BenzDriver extends Factory{

    @Override
    public Car createCar(String car) throws Exception {
        return new Benz();
    }
}

class BmwDriver extends Factory{

    @Override
    public Car createCar(String car) throws Exception {
        return new Bmw();
    }
}

class Demo{
    public static void main(String[] args) throws Exception {
        Factory factory = new BenzDriver();
        Car car = factory.createCar("benz");
        car.setName("benz");
        car.drive();

        Factory factory1 = new BmwDriver();
        Car car1 = factory1.createCar("bmw");
        car1.setName("bmw");
        car1.drive();
    }
}

