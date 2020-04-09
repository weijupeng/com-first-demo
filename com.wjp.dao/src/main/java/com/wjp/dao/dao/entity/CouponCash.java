package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author weijupeng
 */
@Data
@TableName("t_coupon_cash")
public class CouponCash {
    @TableId
    private Long id;
    /**
     * 优惠券ID
     */
    private Long couponId;
    /**
     * 现金券面额
     */
    private BigDecimal couponValue;
    /**
     * 支持前置科目 0 支持所有 1保险费 2风险保障费 3会员费用
     */
    private String supportSubjects;
    /**
     * 最高取现额度
     */
    private BigDecimal highLimitCash;
    /**
     * 最低取现额度
     */
    private BigDecimal lowerLimitCash;
    /**
     * 借款期数
     */
    private String loanPeriods;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}