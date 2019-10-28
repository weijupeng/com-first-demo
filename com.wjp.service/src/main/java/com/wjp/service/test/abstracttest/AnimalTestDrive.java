package com.wjp.service.test.abstracttest;

import com.wjp.service.test.objecttest.Cat;
import com.wjp.service.test.objecttest.Dog;

/**
 * @author weijupeng
 */
public class AnimalTestDrive {

    public static void main(String[] args) {
        MyAnimalList myAnimalList = new MyAnimalList();
        Dog dog = new Dog();
        Cat cat = new Cat();
        myAnimalList.add(dog);
        myAnimalList.add(cat);
    }
}
