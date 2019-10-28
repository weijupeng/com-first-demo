package com.wjp.service.test.innerclass;

/**
 * @author wjp
 * @date 2019/10/28 10:43
 */

public class Circle {
    private double radius;
    public static int COUNT = 1;


    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();
    }

    private Draw getDrawInstance() {
        return new Draw();
    }
    class Draw {
        private double radius = 123;

        public void drawSahpe() {
            System.out.println(Circle.this.radius);  //外部类的private成员
            System.out.println(radius);
            System.out.println(COUNT);   //外部类的静态成员
        }
    }
}
