package com.wmh.utils.password;

/**
 * @program: bill-admin-server
 * @description: 站点对应枚举
 * @author: Mr.Hou
 * @create: 2021-05-20 13:40
 **/
public enum SiteEnum {
    WECHAT("wechat", "微信"),
    SINA("sina", "新浪微博"),
    QQ("qq", "QQ"),
    Mail("mail", "163邮箱"),
    GOOGLE("google", "Google"),
    APPLE("apple", "Apple"),
    BAIDU("baidu", "百度"),
    ALIPAY("alipay", "支付宝"),
    ZHIHU("zhihu", "知乎"),
    GITHUB("github", "Github"),
    ANKI("anki", "Anki单词卡"),
    ORACLE("oracle", "Oracle账户"),
    FACEBOOK("facebook", "Facebook"),
    TWITTER("twitter", "Twitter"),
    BYWAVE("bywave", "Bywave账户"),
    MICRO("micro", "Microsoft微软"),
    SKYPE("skype", "Skype"),
    NETFLIX("netflix", "Netflix"),
    IELTS("ielts", "IELTS雅思"),
    ABOBOO("aboboo", "ABOBOO")

    ;


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private String code;
    private String description;


    SiteEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
