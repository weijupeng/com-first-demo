package com.wjp.test.thread.ticket;

/**
 * @author wjp
 * @date 2019/11/13 16:19
 */
public class MainClass {
    public static void main(String[] args) {
        Station station1 = new Station("站台1");
        Station station2 = new Station("站台2");
        Station station3 = new Station("站台3");

        station1.start();
        station2.start();
        station3.start();
    }
}
