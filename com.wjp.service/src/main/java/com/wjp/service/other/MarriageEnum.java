package com.wjp.service.other;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wjp
 * @date 2019/10/29 17:47
 */

@Getter
@AllArgsConstructor
public enum MarriageEnum {
    /**
     * 婚姻状态
     */
    yh(1, "已婚"),
    wh(2, "未婚"),
    wz(3, "未知"),
    ;
    private Integer key;
    private String value;

    private static HashMap<Integer, String> MarriageEnumMap = new HashMap<>();

    static {
        for (MarriageEnum marriageEnum : MarriageEnum.values()) {
            MarriageEnumMap.put(marriageEnum.key, marriageEnum.value);
        }
    }

    public static String getValue(Integer key) {
        return MarriageEnumMap.getOrDefault(key, "输入错误");
    }

    public static boolean check(Integer key) {
        return MarriageEnumMap.containsKey(key);
    }



}
