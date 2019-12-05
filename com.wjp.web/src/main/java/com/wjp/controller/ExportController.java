package com.wjp.controller;

import com.wjp.common.untils.DateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wjp
 * @date 2019/11/25 15:07
 */
public class ExportController {
    public static void main(String[] args) {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.DATE_PATTERN_YYMM));
        System.out.println("format = " + format);
        String afterMonth = LocalDateTime.now().minusMonths(1).format(DateTimeFormatter.ofPattern(DateUtil.DATE_PATTERN_YYMM));
        System.out.println("afterMonth = " + afterMonth);
    }
}
