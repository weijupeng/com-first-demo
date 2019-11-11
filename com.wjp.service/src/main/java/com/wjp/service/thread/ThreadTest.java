package com.wjp.service.thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wjp
 * @date 2019/11/11 14:28
 */
public class ThreadTest {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strList.add("String" + i);
        }
        int threadNum = strList.size() < 5 ? strList.size() : 5;
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new PrintStringThread(i, strList, threadNum));
        }
        executor.shutdown();

    }
}
