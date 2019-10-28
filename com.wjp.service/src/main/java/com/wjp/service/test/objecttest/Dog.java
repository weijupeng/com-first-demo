package com.wjp.service.test.objecttest;

import lombok.Data;

/**
 * @author weijupeng
 */
@Data
public class Dog extends Animal {
    private int size;
    private String breed;
    private String name;

    void bark() {
        System.out.println("Ruff! Ruff!");
    }

    public static void main(String[] args) {
        int i = 1;
        i = (++i) + (i++);
        System.out.println("i------>" + i);
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        Dog[] myDogs = new Dog[3];

        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        System.out.print("last dog’s name is ");
        System.out.println(myDogs[2].name);
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }

    }
}
