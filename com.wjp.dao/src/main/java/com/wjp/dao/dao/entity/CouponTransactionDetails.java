package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author weijupeng
 */
@Data
@TableName("t_coupon_transaction_details")
public class CouponTransactionDetails {
    @TableId
    private Long id;
    /**
     * 交易流水id
     */
    private Long couponTransactionId;
    /**
     * 用户优惠券id
     */
    private Long custCouponId;
    /**
     * 优惠券类型：现金券，折扣券
     */
    private String couponType;
    /**
     * 优惠券名称
     */
    private String couponName;
    /**
     * 优惠券折扣
     */
    private BigDecimal couponDiscount;
    /**
     * 优惠券面值
     */
    private BigDecimal couponValue;
    /**
     * 最高取现额度
     */
    private BigDecimal highLimitCash;
    /**
     * 最低取现额度
     */
    private BigDecimal lowerLimitCash;
    /**
     * 可用期数
     */
    private Integer validPeriod;
    /**
     * 借款期数
     */
    private String loanPeriods;
    /**
     * 支持前置科目 0 支持所有 1保险费 2风险保障费 3会员费用
     */
    private String supportSubjects;
    /**
     * 支持产品代码
     */
    private String supportProductCode;
    /**
     * 有效期类型 1 时间范围 2 天数
     */
    private Integer validType;
    /**
     * 有效时间范围
     */
    private String validTimeRange;
    /**
     * 有效天数
     */
    private Integer validDays;
    /**
     * 发放截止日期
     */
    private String couponDeadlineDate;
    /**
     * 发放形式 1 主动领取 2被动领取
     */
    private Integer distributeType;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}