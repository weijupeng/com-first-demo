package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/9 15:45
 */
@AllArgsConstructor
@Getter
public enum CouponStatusEnum {

    /**
     * 上架下架
     */
    DOWN(0, "已下架"),
    UP(1, "已上架"),
    ;


    private Integer status;
    private String statusDesc;

    private static HashMap<Integer, String> statusMap = new HashMap<>();

    static {
        for (CouponStatusEnum value : CouponStatusEnum.values()) {
            statusMap.put(value.getStatus(), value.getStatusDesc());
        }
    }

    public static boolean checkContains(Integer status) {
        return statusMap.containsKey(status);
    }

    public static String getDesc(Integer status) {
        return statusMap.getOrDefault(status, "");
    }}
