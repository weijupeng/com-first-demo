package com.wjp.service.multithread.learn;

import static java.lang.Thread.sleep;

/**
 * @author wjp
 * @date 2019/10/31 11:14
 */
public class BaseThread {
    public static void test(String name, int j) {
        for (int i = 0; i < j; i++) {
            System.out.println(name + "运行" + i);
            try {
                sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
