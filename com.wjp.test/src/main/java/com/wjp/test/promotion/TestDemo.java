package com.wjp.test.promotion;

import com.wjp.test.promotion.message.Child;
import com.wjp.test.promotion.message.Parent;

import java.util.Random;

/**
 * @author wjp
 * @date 2020/3/4 11:42
 */
public class TestDemo {
    public static void main(String[] args) {
//        StreamPromotionRequestDTO dto = new StreamPromotionRequestDTO();
//        dto.setMobile("1234");
//        PromotionMessage message = new PromotionMessage();
//        BeanUtils.copyProperties(dto, message);
//        System.out.println(message);
//        System.out.println("+++++++++++++++");
//        System.out.println(message.getMobile());
        for (int i = 0; i < 100; i++) {
            int x = new Random().nextInt(100);
            if (x == 100) {
                System.out.println("命中");
            }
        }
        Parent parent = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Child child : parent.getChildren()) {
            System.out.println("child = " + child);
        }
    }
}
