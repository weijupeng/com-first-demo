package com.wjp.service.test.others;

/**
 * @author wjp
 * @date 2019/10/24 16:39
 */
public class Duck {

    private int size;

    public static void main(String[] args) {
        Duck duck = new Duck();
        System.out.println(duck.size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
