package com.wjp.service.other;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author wjp
 * @date 2019/10/30 11:09
 */
public class MarriageTest {

    Integer key;
    String value;

    public static void main(String[] args) {
        new MarriageTest().test();
    }

    private void test() {

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "231");
        for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }


        HashMap<Integer, String> map = new HashMap<>(16);
        map.put(1, "已婚");
        map.put(2, "未婚");
        map.put(3, "未知");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

    }

    private void go() {
        int c = 4;
        if (MarriageEnum.check(c)) {
            System.out.println(MarriageEnum.getValue(c));
        } else {
            System.out.println(MarriageEnum.getValue(c));
        }

    }
}
