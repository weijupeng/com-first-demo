package com.wjp.test.thread.ticket;

/**
 * @author wjp
 * @date 2019/11/13 16:15
 */
public class Station extends Thread {

    public Station(String name) {
        super(name);
    }

    static int tick = 20;

    static Object ob = "aa";

    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张票");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
