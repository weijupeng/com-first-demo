package com.wjp.service.test.innerclass;

/**
 * @author wjp
 * @date 2019/10/28 11:06
 */
public class Demo {
    public static void main(String[] args) {
        Runnable thread = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("i = " + i);
            }
        };
        Thread t = new Thread(thread);
        t.start();


    }
}
