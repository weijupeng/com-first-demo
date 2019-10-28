package com.wjp.service.test.others;

/**
 * @author weijupeng
 */
public class MyFirstApp {
    private static final int FOUR = 4;

    public static void main(String[] args) {

        int x = 1;
        System.out.println("before the loop ");
        while (x < FOUR) {
            System.out.print("in the loop --->");
            System.out.println("value of x is: " + x);
            x = x + 1;
        }
        System.out.println("value of x is: " + x);
        System.out.println("there is end of loop");



    }
}
