package com.wjp.test.thread.run;

/**
 * @author wjp
 * @date 2019/11/13 16:46
 */
public class MainClass {
    public static void main(String[] args) {
        Tortoise tortoise = new Tortoise();

        Rabbit rabbit = new Rabbit();

        LetOneStop letOneStop1 = new LetOneStop(tortoise);

        rabbit.calltoback = letOneStop1;

        LetOneStop letOneStop2 = new LetOneStop(rabbit);

        tortoise.calltoback = letOneStop2;

        tortoise.start();
        rabbit.start();
    }
}
