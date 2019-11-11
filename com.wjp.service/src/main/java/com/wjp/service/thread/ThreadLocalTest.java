package com.wjp.service.thread;

/**
 * @author wjp
 * @date 2019/11/11 15:20
 */
public class ThreadLocalTest {
    public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int j = 0; j < 5; j++) {
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int num = local.get();
                    for (int i = 0; i < 5; i++) {
                        num++;
                    }
                    local.set(num);
                    System.out.println(Thread.currentThread().getName() + ":" + local.get());
                }

            }, "Thread-" + j);

        }
        for (Thread thread : threads) {
            thread.start();
        }
    }


}
