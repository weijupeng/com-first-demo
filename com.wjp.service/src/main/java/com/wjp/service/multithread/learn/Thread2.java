package com.wjp.service.multithread.learn;

/**
 * @author wjp
 * @date 2019/10/31 11:13
 */
public class Thread2 implements Runnable {
    private String name;

    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        BaseThread.test(name, 5);
    }


    public static void main(String[] args) {
        new Thread(new Thread2("A")).start();
        new Thread(new Thread2("B")).start();
    }
}
