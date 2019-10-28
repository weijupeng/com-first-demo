package com.wjp.api.resp.userorder;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author weijupeng
 */
@Data
public class OrderInfo {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * vbs_bid
     */
    private String vbsBid;
    /**
     * 提现金额
     */
    private BigDecimal loanAmount;
    /**
     * 贷款期数
     */
    private Integer loadPeriods;
    /**
     * 资方名称
     */
    private String fundName;
    /**
     * 贷款类型
     */
    private String loanType;
    /**
     * 提现时间
     */
    private String cashTime;
    /**
     * 状态(还款完成)
     */
    private String state;

}
