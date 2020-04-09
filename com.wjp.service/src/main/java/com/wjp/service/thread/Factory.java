package com.wjp.service.thread;

import javax.xml.ws.Service;

/**
 * @author wjp
 * @date 2019/11/11 14:48
 */
public class Factory {
    int zhuanTou = 20;

    public synchronized int getZhuanTou() {

        if (zhuanTou == 0) {
            throw new RuntimeException(Thread.currentThread().getName() + "没有砖头了");
        }
        Thread.yield();
        return zhuanTou--;

    }

    public class Person extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(getName() + "搬了第" + getZhuanTou() + "块砖头");
                Thread.yield();
            }
        }
    }

    public Person getPerson() {
        return new Person();
    }

}
