package com.wjp.service.test.abstracttest;

/**
 * @author weijupeng
 */
public class BUZZworcboReport extends Report {
    public static void main(String[] args) {
        BUZZworcboReport report = new BUZZworcboReport();
        report.runReport();
    }

    @Override
    void runReport() {
        System.out.println("12345");
        super.runReport();
        Object o = printReport();
        System.out.println((int) o + 1);
    }

}
