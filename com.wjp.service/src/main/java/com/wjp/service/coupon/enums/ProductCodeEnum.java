package com.wjp.service.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author cailin
 * @since 2019/9/6
 */
@Getter
@AllArgsConstructor
public enum ProductCodeEnum {
    /**
     *
     */
    KK("PDCD000032", "卡卡贷"),
    DD("PDCD000012", "豆豆钱"),
    SD("PDCD000079", "闪贷");

    private String code;
    private String message;

    private static Map<String, String> productCodeMap = new HashMap();

    static {
        for (ProductCodeEnum type : ProductCodeEnum.values()) {
            productCodeMap.put(type.getCode(), type.getMessage());
        }
    }

    public static boolean checkContains(String productCode) {
        return productCodeMap.containsKey(productCode);
    }

    public static String getProductName(String productCode) {
        return productCodeMap.getOrDefault(productCode, productCode);
    }

}
