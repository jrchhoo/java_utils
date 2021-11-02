package com.wmh.utils.compare;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/**
 * @program: utils
 * @description: 比较大小
 * @author: Mr.Hou
 * @create: 2021-11-01 15:08
 **/
public class CompareUtil<T> {

    public static <T> void sort(List<T> targetList, final String sortField,
                                final boolean sortMode) {
        if (targetList == null || targetList.size() < 2 || sortField == null || sortField.length() == 0) {
            return;
        }
        Collections.sort(targetList, new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                int retVal = 0;
                try {

                    String methodStr = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1);
                    Method method1 = ((T) obj1).getClass().getMethod(methodStr, null);
                    Method method2 = ((T) obj2).getClass().getMethod(methodStr, null);
                    if (sortMode) {
                        retVal = method1.invoke(((T) obj1), null).toString().compareTo(method2.invoke(((T) obj2), null).toString());
                    } else {
                        retVal = method2.invoke(((T) obj2), null).toString().compareTo(method1.invoke(((T) obj1), null).toString());
                    }
                } catch (Exception e) {
                    System.out.println("List<" + ((T) obj1).getClass().getName() + ">排序异常！");
                    e.printStackTrace();
                }
                return retVal;
            }
        });
    }


    public static void main(String[] args) throws InterruptedException {

        List<Dog> dogList = new ArrayList<Dog>();
        Dog dog1 = new Dog("ddd", new BigDecimal("33445.9980"));
        Dog dog2 = new Dog("xxx", new BigDecimal("56845.9980"));
        Dog dog3 = new Dog("ccc", new BigDecimal("4327719.9980"));
        Dog dog4 = new Dog("bbb", new BigDecimal("77998.9980"));
        Dog dog5 = new Dog("aaa", new BigDecimal("21667.9980"));
        Dog dog6 = new Dog("fff", new BigDecimal("7554789.9980"));
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
        dogList.add(dog5);
        dogList.add(dog6);
        System.out.println("排序前:" + dogList.toString());

        System.out.println(dogList.subList(5, 5));

        CompareUtil.sort(dogList, "testDecimal", true);
        for (Dog dog : dogList) {
            System.out.println(dog.toString());
        }

    }
}

class Dog {
    private String name;

    private BigDecimal testDecimal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTestDecimal() {
        return testDecimal;
    }

    public void setTestDecimal(BigDecimal testDecimal) {
        this.testDecimal = testDecimal;
    }

    public Dog(String name, BigDecimal testDecimal) {
        this.name = name;
        this.testDecimal = testDecimal;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", testDecimal=" + testDecimal +
                '}';
    }
}





