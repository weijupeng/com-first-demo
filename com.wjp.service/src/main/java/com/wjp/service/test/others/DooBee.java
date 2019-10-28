package com.wjp.service.test.others;

public class DooBee {
    private final static String STR = "DooBeeDooBeeDo";
    private final static int THREE = 3;

    public static void main(String[] args) {
        int x = 1;
        StringBuilder builder = new StringBuilder();
        while (x < THREE) {
            System.out.print("Doo");
            builder.append("Doo");
            System.out.print("Bee");
            builder.append("Bee");
            x = x + 1;
        }
        if (x == THREE) {
            System.out.println("Do");
            builder.append("Do");
        }
        if (STR.equals(builder.toString())) {
            System.out.println("true");
        }
    }
}