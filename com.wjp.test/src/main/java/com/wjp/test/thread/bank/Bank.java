package com.wjp.test.thread.bank;

import java.util.Objects;

/**
 * @author wjp
 * @date 2019/11/13 16:23
 */
public class Bank {
    static double money = 2000;

    // 柜台Counter取钱的方法
    private void counter(double money) {
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元");
    }

    // ATM取钱的方法
    private void ATM(double money) {
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    public synchronized void outMoney(double money, String mode) throws Exception {
        if (money > Bank.money) {
            throw new Exception("全款金额" + money + "，余额只剩" + Bank.money + "，取款失败");
        }
        if (Objects.equals(mode, "ATM")) {
            ATM(money);
        } else {
            counter(money);
        }

    }

}
