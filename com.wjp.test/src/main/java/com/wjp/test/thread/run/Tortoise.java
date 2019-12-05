package com.wjp.test.thread.run;

/**
 * @author wjp
 * @date 2019/11/13 16:44
 */
public class Tortoise extends Animal {
    public Tortoise() {
        setName("乌龟");
    }

    @Override
    public void runing() {
        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");
            // 让兔子不要在跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
