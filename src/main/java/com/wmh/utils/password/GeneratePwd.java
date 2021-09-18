package com.wmh.utils.password;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bill-admin-server
 * @description: 生成密码程序
 * @author: Mr.Hou
 * @create: 2021-01-28 23:55
 **/
public class GeneratePwd {

    public static void generatePwd(SiteEnum siteEnum) {
        List<String> oddNumberList = new ArrayList<>();

        StringBuffer alphabetBuffer = new StringBuffer();
        StringBuffer markBuffer = new StringBuffer();

        PwdEnum pwdEnum;
        String siteName = siteEnum.getCode();
        for (int i = 0; i < siteName.length(); i++) {
            if (i == 0 || i == siteName.length() - 1) {
                pwdEnum = PwdEnum.getEnumFromAlphabet(String.valueOf(siteName.charAt(i)));
                alphabetBuffer.append(siteName.charAt(i));
                markBuffer.append(pwdEnum.getMark());
            }

            if (siteName.length() > 2 && i % 2 != 0) {
                continue;
            }
            oddNumberList.add(String.valueOf(siteName.charAt(i)));
        }

        StringBuffer pwdNumber = new StringBuffer();
        StringBuffer numberBuffer = new StringBuffer();

        String shortPrefix = "Wmhou@";
        for (int i = 0; i < oddNumberList.size(); i++) {
            pwdEnum = PwdEnum.getEnumFromAlphabet(oddNumberList.get(i));
            numberBuffer.append(pwdEnum.getCode());
        }
        pwdNumber.append(shortPrefix).append(numberBuffer).append(".").append(alphabetBuffer).append(markBuffer);
        System.out.println("======" + siteEnum.getDescription() + "====== 密码：" + pwdNumber.toString());
    }


    public static void main(String[] args) {
        SiteEnum[] siteEnums = SiteEnum.values();
        for (SiteEnum siteEnum: siteEnums) {
            GeneratePwd.generatePwd(siteEnum);
        }
    }
}
