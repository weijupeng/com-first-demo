package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/9 10:44
 */
@Getter
@AllArgsConstructor
public enum LoanPeriodEnum {
    /**
     * 借款期数
     */
    THREE("3", "三期"),
    SIX("6", "六期"),
    NINE("9", "九期"),
    TWELVE("12", "十二期");

    private String LoanPeriod;
    private String LoanPeriodName;


    private static HashMap<String, String> loanPeriodMap = new HashMap<>();

    static {
        for (LoanPeriodEnum value : LoanPeriodEnum.values()) {
            loanPeriodMap.put(value.getLoanPeriod(), value.getLoanPeriodName());
        }
    }


    public static boolean checkContains(String loanPeriod) {
        return loanPeriodMap.containsKey(loanPeriod);
    }
}
