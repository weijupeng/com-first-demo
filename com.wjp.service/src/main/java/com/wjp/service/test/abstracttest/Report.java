package com.wjp.service.test.abstracttest;

abstract class Report {
    void runReport() {
        System.out.println("123");
    }

    Object printReport() {
        System.out.println("1234");
        return 1;
    }
}
