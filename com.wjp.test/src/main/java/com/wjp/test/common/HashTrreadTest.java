package com.wjp.test.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wjp
 * @date 2019/12/26 9:54
 */
public class HashTrreadTest {

    static HashMap<Integer, Integer> map = new HashMap<>(2);


    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger at = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (at.get() < 100000) {
                        map.put(at.get(), at.get());
                        at.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println("key: " + iterator.next() + ",value: " + map.get(iterator.next()));
        }
    }
}
