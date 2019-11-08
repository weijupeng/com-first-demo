package com.wjp.service.test.line;

/**
 * @author wjp
 * @date 2019/10/28 16:49
 */
public class ThreadTester   {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);

        myThread.start();
        System.out.println("back in main");
    }


}
