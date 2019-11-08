package com.wjp.service.test.line;

/**
 * @author wjp
 * @date 2019/10/28 17:04
 */
public class RunThreads implements Runnable {

    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("alpha");
        beta.setName("beta");
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is Running");
        }
    }
}
