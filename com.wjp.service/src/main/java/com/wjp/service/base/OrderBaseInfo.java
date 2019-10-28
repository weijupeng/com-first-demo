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
public class OrderBaseInfo {
    /**
     * 当前状态
     */
    private String status;
    /**
     * 签约时间
     */
    private String agencyTime;
    /**
     * 签约金额
     */
    private BigDecimal agencyAmount;
    /**
     * 贷款期数
     */
    private Integer loanPeriods;
    /**
     * 月综合费率
     */
    private String monthRate;
    /**
     * 放款时间  todo
     */
    private String loanTime;
    /**
     * 贷款类型
     */
    private String loanType;
    /**
     * 月综合费率等级
     */
    private String monthRateLevel;
    /**
     * 资方名称
     */
    private String fundName;


}
