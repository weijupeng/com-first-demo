package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/9 10:12
 */
@AllArgsConstructor
@Getter
public enum DistributeTypeEnum {
    /**
     * 领取类型
     */
    Active(2, "主动"),
    Passive(1, "被动"),
    ;
    private Integer distributeType;
    private String distributeTypeName;

    private static HashMap<Integer, String> couponTypeMap = new HashMap<>();

    static {
        for (DistributeTypeEnum value : DistributeTypeEnum.values()) {
            couponTypeMap.put(value.getDistributeType(), value.getDistributeTypeName());
        }
    }


    public static boolean checkContains(Integer distributeType) {
        return couponTypeMap.containsKey(distributeType);
    }

    public static String getDesc(Integer distributeType) {
        return couponTypeMap.getOrDefault(distributeType, "");
    }}
