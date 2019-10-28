package com.wjp.service.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author weijupeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditInfo {
    /**
     * 授信时间
     */
    private String creditTime;
    /**
     * 客户总额度
     */
    private BigDecimal customerAllLines;
    /**
     * 可用额度
     */
    private BigDecimal availableLines;
    /**
     * 客户标签
     */
    private String customerLabel;
    /**
     * 客户等级
     */
    private Integer customerLevel;
    /**
     * 客户补充标签
     */
    private String customerSupplementLabel;
    /**
     * 额度失效时间
     */
    private String linesExpirationTime;
    /**
     * 征信通道
     */
    private String reportChannel;
}
