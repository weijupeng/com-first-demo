package com.wjp.test.promotion.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * StreamPromotionRequestDTO
 * <p>
 * @author: kancy
 * @date: 2020/3/2 11:49
 **/
@Data
public class StreamPromotionRequestDTO extends PromotionRequestDTO implements Serializable {
    private static final long serialVersionUID = 23124412361821471L;

    public StreamPromotionRequestDTO() {
        super.setPromoteSource(1);
    }

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
