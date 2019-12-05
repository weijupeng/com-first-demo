package com.wjp.test.thread.bank;

/**
 * @author wjp
 * @date 2019/11/13 16:34
 */
public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank();

        PersonA a = new PersonA(bank, "counter");
        PersonB b = new PersonB(bank, "ATM");
        a.start();
        b.start();
    }
}
