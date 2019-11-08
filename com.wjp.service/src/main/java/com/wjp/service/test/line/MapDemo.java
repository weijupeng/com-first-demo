package com.wjp.service.test.line;

import com.wjp.service.test.objecttest.Dog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/10/28 18:14
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        System.out.println(map.get(3));

    }
}
