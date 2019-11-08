package com.wjp.service.test.line;

/**
 * @author wjp
 * @date 2019/10/28 16:48
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    private void go() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doMore();
    }

    private void doMore() {
        System.out.println("Top o the stack");
    }
}
