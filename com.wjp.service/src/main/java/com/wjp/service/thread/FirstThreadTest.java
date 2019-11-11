package com.wjp.service.thread;

/**
 * @author wjp
 * @date 2019/11/11 14:39
 */
public class FirstThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("这里是线程的执行方法");
    }

    public static void main(String[] args) {
        FirstThreadTest threadTest = new FirstThreadTest();
        System.out.println("线程名称为" + threadTest.getName());

        threadTest.start();
        System.out.println("main方法也是一个线程：" + Thread.currentThread().getName());
    }
}
