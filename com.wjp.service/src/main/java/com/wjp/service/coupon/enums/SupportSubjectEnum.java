package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @author wjp
 * @date 2019/12/9 9:49
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SupportSubjectEnum {
    /**
     * 支持前置科目枚举
     */
    ALL("0", "支持所有"),
    Insurance("1", "保险费"),
    RISK_PROTECTION_FEES("2", "风险保障费"),
    MEMBER_FEES("3", "会员费用"),
    ;

    private String subjectValue;
    private String subjectName;

    private static HashMap<String, String> supportSubjectMap = new HashMap<>();

    static {
        for (SupportSubjectEnum value : SupportSubjectEnum.values()) {
            supportSubjectMap.put(value.getSubjectValue(), value.getSubjectName());
        }
    }


    public static boolean checkContains(String subjectValue) {
        return supportSubjectMap.containsKey(subjectValue);
    }

    public static String getDesc(String supportSubjects) {
        String[] split = supportSubjects.split(",");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = supportSubjectMap.getOrDefault(split[i], "");
            builder.append(s + ",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return String.valueOf(builder);
    }}
