package com.wjp.test.thread.run;

/**
 * @author wjp
 * @date 2019/11/13 16:37
 */
public abstract class Animal extends Thread {
    public int length = 2000;

    public abstract void runing();

    @Override
    public void run() {

        super.run();
        while (length > 0) {
            runing();
        }
    }


    public  interface Calltoback {
         void win();
    }

    public Calltoback calltoback;
}

