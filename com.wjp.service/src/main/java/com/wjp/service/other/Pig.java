package com.wjp.service.other;

/**
 * @author wjp
 * @date 2019/10/29 16:31
 */
public class Pig {
    private String name;

    static class Big {
         void go() {
            System.out.println("inner");
        }
    }
}
