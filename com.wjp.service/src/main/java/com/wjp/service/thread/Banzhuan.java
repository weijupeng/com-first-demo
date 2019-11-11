package com.wjp.service.thread;

/**
 * @author wjp
 * @date 2019/11/11 14:48
 */
public class Banzhuan {
    public static void main(String[] args) {
        Factory factory = new Factory();


        Factory.Person p1 = factory.getPerson();
        Factory.Person p2 = factory.getPerson();
        p1.start();
        p2.start();

    }
}
