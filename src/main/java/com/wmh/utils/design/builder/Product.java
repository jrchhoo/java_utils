package com.wmh.utils.design.builder;

import lombok.Data;

/**
 * @program: bill-admin-server
 * @description: 产品，一个产品多个部件组成
 * @author: Mr.Hou
 * @create: 2020-12-15 14:44
 **/

@Data
public class Product {

    private String partA;
    private String partB;
    private String partC;

    public void show(){
        System.out.println("产品生产出来了");
    }
}
