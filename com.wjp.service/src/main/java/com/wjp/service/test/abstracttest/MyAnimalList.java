package com.wjp.service.test.abstracttest;

import com.wjp.service.test.objecttest.Animal;

/**
 * @author weijupeng
 */
public class MyAnimalList {
    private Animal[] animals = new Animal[5];

    private int nextIndex = 0;

    public void add(Animal d) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = d;
            System.out.println("Dog added at" + nextIndex);
            nextIndex++;
        }
    }
}
