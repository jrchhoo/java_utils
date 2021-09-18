package com.wmh.utils.design.abstractfactory;

import lombok.Data;

/**
 * @program: bill-admin-server
 * @description: 抽象工厂模式
 * @author: Mr.Hou
 * @create: 2020-12-07 16:24
 **/
public class AbstractFactory {

    public static void main(String[] args) throws Exception {
        Driver driver = new BusinessDriver();
        BmwCar car = driver.createBmwCar("bmw9090");
        car.drive();

        BenzCar car1 = driver.createBenzCar("benz9090");
        car1.drive();

        Driver driver1 = new SportDriver();
        BmwCar car3 = driver1.createBmwCar("bmw9090");
        car3.drive();

        BenzCar car4 = driver1.createBenzCar("benz9090");
        car4.drive();
    }
}

/**
 * 抽象产品
 */
@Data
abstract class BenzCar{
    private String name;
    public abstract void drive();
}

/**
 * 具体产品
 */
class BenzSportCar extends BenzCar{

    @Override
    public void drive() {
        System.out.println("---BenzSportCar---");
    }
}

class BenzBusinessCar extends BenzCar{

    @Override
    public void drive() {
        System.out.println("---BenzBusinessCar---");
    }
}

/**
 * 抽象产品
 */
@Data
abstract class BmwCar{
    private String name;
    public abstract void drive();
}

/**
 * 具体产品
 */
class BmwSportCar extends BmwCar{

    @Override
    public void drive() {
        System.out.println("---BmwSportCar---");
    }
}

class BmwBusinessCar extends BmwCar{

    @Override
    public void drive() {
        System.out.println("---BmwBusinessCar---");
    }
}

/**
 * 抽象工厂
 */
abstract class Driver{

    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;
}

/**
 * 具体工厂
 */
class SportDriver extends Driver{

    @Override
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzSportCar();
    }

    @Override
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwSportCar();
    }
}

/**
 * 具体工厂
 */
class BusinessDriver extends Driver{

    @Override
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }

    @Override
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }
}