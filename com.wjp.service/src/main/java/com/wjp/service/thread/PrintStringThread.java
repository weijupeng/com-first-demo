package com.wjp.service.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wjp
 * @date 2019/11/11 14:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintStringThread implements Runnable {

    private int num;

    private List<String> strList;

    private int threadNum;


    @Override
    public void run() {
        int length = 0;
        for (String str : strList) {
            if (length % threadNum == num) {
                System.out.println("线程编号：" + num + "，字符串：" + str);
            }
        }
    }
}
