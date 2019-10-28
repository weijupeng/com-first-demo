package com.wjp.service.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weijupeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankCard {
    /**
     * 放款卡银行
     */
    private String loanCardBank;
    /**
     * 还款卡银行
     */
    private String repaymentCardBank;
    /**
     * 放款卡卡号
     */
    private String loanCardNo;
    /**
     * 还款卡卡号
     */
    private String repaymentCardNo;
    /**
     * 放款卡类型
     */
    private String loanCardType;
    /**
     * 还款卡类型
     */
    private String repaymentCardType;
}
