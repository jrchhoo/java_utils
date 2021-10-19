package com.wmh.utils.arraysutil;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: utils
 * @description: 数组
 * @author: Mr.Hou
 * @create: 2021-10-08 15:17
 **/
public class ArraysUtil {

    public static void compareContain(String str1,String str2){
        String[] number = str1.split("\\s+");
        //Arrays.sort(number);
        //String formatNumber = String.join("," , number);
        String[] temp = str2.split("\\|");
        for (int i = 0; i < temp.length; i++) {
            String[] detail = temp[i].split(",");
            System.out.println("size:" +temp.length + "  value:" + temp[i]);
            if (!Arrays.asList(number).containsAll(Arrays.asList(detail))){
                System.out.println(temp[i]);
            }
        }



    }


    public static void main(String[] args) {
        String number = "12 44 32 09 16 21";
        String temp = "12,32,16,33,45";
        ArraysUtil.compareContain(number,temp);

        //List<String> list1 = Lists.newArrayList("12","44","32","09","16","21");
        //List<String> list2 = Lists.newArrayList("12","32","02");
        //System.out.println(list1.containsAll(list2));

        String nu = "20211011-122";
        String nu1 = "20211011";
        System.out.println(nu.split("-")[0]);
        System.out.println(nu1.split("-")[0]);

    }
}
