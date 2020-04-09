package com.wjp.common.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wjp
 * @date 2020/3/3 11:08
 */
public class demo {
    public static void main(String[] args) {
        String s = "ddq,shandai";
        String s2 = "ddq23,shandai";
        String s3 = "ddq3,shandai";
        System.out.println(s.contains("ddq"));
        ArrayList<String> strings = new ArrayList<>();
        strings.add(s);
        strings.add(s2);
        strings.add(s3);

        List<String> ddq = strings.stream().filter(s1 -> {
            return s1.contains("ddq");
        }).sorted((o1, o2) -> o2.length() - o1.length()).collect(Collectors.toList());
        System.out.println("ddq = " + ddq);
    }
}
