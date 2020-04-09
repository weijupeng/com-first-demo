package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/6 10:26
 */
@Getter
@AllArgsConstructor
public enum CouponTypeEnum {
    /**
     * 券类型
     */
    CASH("1", "现金券"),
    DISC("2", "折扣券");

    private String couponType;
    private String couponTypeName;

    private static HashMap<String, String> couponTypeMap = new HashMap<>();

    static {
        for (CouponTypeEnum value : CouponTypeEnum.values()) {
            couponTypeMap.put(value.getCouponType(), value.getCouponTypeName());
        }
    }


    public static boolean checkContains(String couponType) {
        return couponTypeMap.containsKey(couponType);
    }

    public static String getDesc(String couponType) {
        return couponTypeMap.getOrDefault(couponType, "");
    }}
