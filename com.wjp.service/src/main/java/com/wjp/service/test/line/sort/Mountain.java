package com.wjp.service.test.line.sort;

/**
 * @author wjp
 * @date 2019/10/29 9:36
 */
public class Mountain {
    String name;
    int height;

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
