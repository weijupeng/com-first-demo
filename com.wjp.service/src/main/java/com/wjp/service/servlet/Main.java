package com.wjp.service.servlet;

/**
 * @author wjp
 * @date 2019/11/13 11:08
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Thread t = new Thread(main.runnable);
        System.out.println("This is main");
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("In Main");
            e.printStackTrace();
        }
        t.interrupt();

    }

    private Runnable runnable = () -> {
        int i = 0;
        try {
            while (i < 1000) {
                Thread.sleep(500);
                System.out.println(i++);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isAlive());
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("In Runnable");
            e.printStackTrace();
        }

    };
}
