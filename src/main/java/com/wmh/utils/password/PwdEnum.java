package com.wmh.utils.password;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bill-admin-server
 * @description: 密码键盘对应
 * @author: Mr.Hou
 * @create: 2021-01-28 23:47
 **/
public enum PwdEnum {
    QAZ("1", "!", Lists.newArrayList("q", "a", "z")),
    WSX("2", "@", Lists.newArrayList("w", "s", "x")),
    EDC("3", "#", Lists.newArrayList("e", "d", "c")),
    RFV("4", "$", Lists.newArrayList("r", "f", "v")),
    TGB("5", "%", Lists.newArrayList("t", "g", "b")),
    YHN("6", "^", Lists.newArrayList("y", "h", "n")),
    UJM("7", "&", Lists.newArrayList("u", "j", "m")),
    IK("8", "*", Lists.newArrayList("i", "k")),
    OL("9", "(", Lists.newArrayList("o", "l")),
    P("0", ")", Lists.newArrayList("p"));


    private String code;
    private String mark;
    private List<String> alphabet;

    PwdEnum(String code, String mark, ArrayList<String> alphabet) {
        this.code = code;
        this.mark = mark;
        this.alphabet = alphabet;
    }

    public static PwdEnum getEnumFromAlphabet(String alphabet) {

        for (PwdEnum pwdEnum: PwdEnum.values()) {
            if (pwdEnum.getAlphabet().contains(alphabet)) {
                return pwdEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMark() {
        return mark;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }
}
