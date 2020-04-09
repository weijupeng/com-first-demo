package com.wjp.service.coupon.other;

import com.wjp.service.others.StringUtil;

/**
 * @author wjp
 * @date 2019/12/11 9:55
 */
public class DemoCkas {
    private static String resolveName(String name) {
        if (StringUtil.isEmpty(name)) {
            return name;
        }
        return name.substring(0, 1) + "**";
    }

    public static void main(String[] args) {
        String s = "123213123";
        String s1 = resolveName(s);
        System.out.println("s1 = " + s1);
    }
}