package com.wjp.service.test.others;

/**
 * @author wjp
 * @date 2019/10/24 14:01
 */
public class SingleObjectDemo {
    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        instance.go();
        double random = Math.round(22.9);
        System.out.println("random = " + random);
    }
}
