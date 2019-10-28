package com.wjp.api.resp.userorder;

public class StringDemo2 {
    public static void main(String[] args) {
        /*
         * \d{15}(\d{2}[0-9xX])?
         */
        String regex = "\\d{15}(\\d{2}[0-9xX])?";
        String id = "41052219951133";

        if (id.matches(regex)) {
            System.out.println("是身份证号");
        } else {
            System.out.println("不是身份证号");
        }
    }
}
