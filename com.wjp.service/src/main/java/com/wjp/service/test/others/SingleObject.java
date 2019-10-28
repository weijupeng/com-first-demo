package com.wjp.service.test.others;

/**
 * @author wjp
 * @date 2019/10/24 9:48
 */
public class SingleObject {

    private SingleObject() {
    }

    private static SingleObject test;

    public static SingleObject getInstance() {
        if (test == null) {
            test = new SingleObject();
        }
        return test;
    }

    public void go() {
        System.out.println("Hello World");
    }


}
