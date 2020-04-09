package com.wjp.test.promotion.message;

import lombok.Data;

/**
 * <p>
 * PromotionMessage
 * <p>
 * @author: kancy
 * @date: 2020/3/2 23:36
 **/
@Data

public class PromotionMessage extends AbstractPromotionMessage {
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 当前步骤
     */
    private String step;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * pid
     */
    private String pid;
    /**
     * 授信流水号
     */
    private String creditSerialNo;
    /**
     * 订单类型 （1-首贷，2-加贷，3-再贷，4-首贷非首笔）
     */
    private Integer orderType;
}
