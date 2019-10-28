package com.wjp.service.test.abstracttest;

import com.wjp.service.test.objecttest.Dog;

/**
 * @author weijupeng
 */
public class MyDogList {
    private Dog[] dogs = new Dog[5];

    private int nextIndex = 0;

    public void add(Dog d) {
        if (nextIndex < dogs.length) {
            dogs[nextIndex] = d;
            System.out.println("Dog added at" + nextIndex);
            nextIndex++;
        }
    }


}
