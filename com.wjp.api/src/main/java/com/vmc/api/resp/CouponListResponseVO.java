package com.vmc.api.resp;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wjp
 * @date 2019/12/6 10:10
 */
@Data
public class CouponListResponseVO {
    /**
     * 优惠券ID
     */
    private Long couponId;
    /**
     * 优惠券类型：1现金券
     */
    private String couponType;
    /**
     * 优惠券类型描述
     */
    private String couponTypeDesc;
    /**
     * 支持产品
     */
    private String supportProductCode;
    /**
     * 支持前置科目 0 支持所有 1保险费 2风险保障费 3会员费用
     */
    private String supportSubjects;
    /**
     * 支持前置科目描述
     */
    private String supportSubjectsDesc;
    /**
     * 优惠券名称
     */
    private String couponName;
    /**
     * 优惠券面值
     */
    private BigDecimal couponValue;
    /**
     * 最低取现金额
     */
    private BigDecimal lowerLimitCash;
    /**
     * 借款期数
     */
    private String loanPeriods;
    /**
     * 使用说明
     */
    private String description;
    /**
     * 1被动领取、2主动领取
     */
    private Integer distributeType;
    /**
     * 发放形式
     */
    private String distributeTypeDesc;
    /**
     * 优惠券数量
     */
    private Integer couponAmount;
    /**
     * 有效期类型 1 按时间范围 2 按天数
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
     * 状态
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDesc;


}
