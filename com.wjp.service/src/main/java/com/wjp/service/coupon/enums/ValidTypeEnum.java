package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/9 10:37
 */
@AllArgsConstructor
@Getter
public enum ValidTypeEnum {
    /**
     * 有效期类型枚举
     */
    TIMERANGE(1, "时间范围"),
    DAYS(2, "有效天数"),
    ;
    private Integer validType;
    private String validTypeName;

    private static HashMap<Integer, String> validTypeEnumMap = new HashMap<>();

    static {
        for (ValidTypeEnum value : ValidTypeEnum.values()) {
            validTypeEnumMap.put(value.getValidType(), value.getValidTypeName());
        }
    }

    public static boolean checkContains(Integer validType) {
        return validTypeEnumMap.containsKey(validType);
    }


}
