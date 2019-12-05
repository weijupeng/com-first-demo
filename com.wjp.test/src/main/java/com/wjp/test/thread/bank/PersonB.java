package com.wjp.test.thread.bank;

/**
 * @author wjp
 * @date 2019/11/13 16:32
 */
public class PersonB extends Thread {
    Bank bank;

    String mode;

    public PersonB(Bank bank, String mode) {
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run() {
        while (Bank.money >= 200) {
            try {
                bank.outMoney(200,mode);
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
