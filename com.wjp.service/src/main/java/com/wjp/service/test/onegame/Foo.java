package com.wjp.service.test.onegame;

import java.util.ArrayList;

/**
 * @author wjp
 * @date 2019/10/25 10:32
 */
public class Foo {

    public static void main(String[] args) {
        go();
    }

    private static void go() {
        int x = 3;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(x);
        int integer = list.get(0);
        list.add(0, 2);
        System.out.println(list);

        boolean flase = Boolean.parseBoolean("1");
        System.out.println("flase = " + flase);
    }
}
