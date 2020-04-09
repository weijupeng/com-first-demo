package com.wjp.test.distinct;

import org.apache.commons.codec.binary.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wjp
 * @date 2020/4/8 15:26
 */
public class DistinctDemo {
    public static void main(String[] args) {
        List<MyUser> list1 = new ArrayList<>();
        MyUser user1 = new MyUser();
        user1.setUserName("zhangsan");
        user1.setPassWord("123456");
        list1.add(user1);

        MyUser user2 = new MyUser();
        user2.setUserName("zhangsan");
        user2.setPassWord("123456");
        list1.add(user2);

        MyUser user3 = new MyUser();
        user3.setUserName("lisi");
        user3.setPassWord("123456");
        list1.add(user3);

        MyUser user4 = new MyUser();
        user4.setUserName("lisi");
        user4.setPassWord("123456");
        list1.add(user4);

        //去重
        list1 = removeDuplicateOutputField(list1);

        for (MyUser b : list1) {
            System.out.println("去重后：" + b.toString());
        }
    }

    /**
     * 根据list中对象某些字段去重
     * @param list 需要去重的list
     * @return 返回去重后的list
     */
    private static List<MyUser> removeDuplicateOutputField(List<MyUser> list) {
        Set<MyUser> set = new TreeSet<>((o1, o2) -> {
            int compareToResult = 1;
            //根据需求添加StringUtils.equals(o1.getUserName(), o2.getUserName()) ；
            if (StringUtils.equals(o1.getUserName(), o2.getUserName()) &&
                    StringUtils.equals(o1.getPassWord(), o2.getPassWord())) {
                compareToResult = 0;
            }
            return compareToResult;
        });
        set.addAll(list);
        return new ArrayList<>(set);
    }
}
