package com.wjp.service.test.objecttest;

/**
 * @author weijupeng
 */
public class BookTestDrive {
    public static void main(String[] args) {
        Book a = new Book();
        Book b = a;
        a.page = 10;
        System.out.println(b.page);
    }
}
