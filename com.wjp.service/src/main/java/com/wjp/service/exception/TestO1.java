package com.wjp.service.exception;

import java.util.Scanner;

/**
 * @author wjp
 * @date 2019/10/31 15:59
 */
public class TestO1 {
    public static void main(String[] args) {
        System.out.println("请输入您的选择：(1-3之间的整数)");
        Scanner input = new Scanner(System.in);
        int num = 0;
        try {
            num = input.nextInt();
        } catch (Exception e) {
            throw new MyException("自定义异常");
        }
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
