package com.wmh.utils.stringutil;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: utils
 * @description: String工具
 * @author: Mr.Hou
 * @create: 2021-10-19 10:46
 **/
public class StringUtil {

    public static void main(String[] args) {
        String number = "aa bb cc dd ee nn";
        System.out.println(StringUtils.replace(number, " ", ",", -1));
    }
}
