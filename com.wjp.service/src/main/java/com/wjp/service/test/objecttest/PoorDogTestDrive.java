package com.wjp.service.test.objecttest;

/**
 * @author weijupeng
 */
public class PoorDogTestDrive {
    public static void main(String[] args) {
        PoorDog poorDog = new PoorDog();
        int x = 6;
        int y = 6;
        poorDog.setSize(x);
        if (poorDog.getSize() == y) {
            System.out.println("? ? ?");
        }
        System.out.println(poorDog.getName());
        System.out.println(poorDog.getSize());
    }
}
