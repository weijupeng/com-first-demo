package com.wjp.service.test.objecttest;

/**
 * @author weijupeng
 */
public class DogTestDrive {
    public static void main(String[] args) {
        Dog[] pets;
        pets = new Dog[7];
        pets[0] = new Dog();
        pets[2] = new Dog();
        System.out.println(pets[2]);
        Dog dog = new Dog();
        dog.setSize(40);
        dog.bark();
        System.out.println(dog.getSize());
    }
}
