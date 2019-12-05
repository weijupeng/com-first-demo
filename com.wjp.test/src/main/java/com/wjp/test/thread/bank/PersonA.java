package com.wjp.test.thread.bank;

/**
 * @author wjp
 * @date 2019/11/13 16:32
 */
public class PersonA extends Thread {
    Bank bank;

    String mode;

    public PersonA(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            try {
                bank.outMoney(100,mode);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}