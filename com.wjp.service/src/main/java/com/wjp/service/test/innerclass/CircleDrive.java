package com.wjp.service.test.innerclass;

/**
 * @author wjp
 * @date 2019/10/28 10:46
 */
public class CircleDrive {
    public static void main(String[] args) {
        Circle circle = new Circle(12.3);
        Circle.Draw draw = circle.new Draw();
        draw.drawSahpe();
    }
}
