package com.wjp.service.thread;

/**
 * @author wjp
 * @date 2019/11/11 14:46
 */
public class RunnableThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println("这里是线程方法");
        System.out.println("线程名为：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main方法线程：" + Thread.currentThread().getName());
        RunnableThreadTest rtt = new RunnableThreadTest();
        new Thread(rtt, "新线程1").start();
        new Thread(rtt, "新线程2").start();
    }
}
