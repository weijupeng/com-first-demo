package com.vmc.api.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author wjp
 * @date 2019/12/5 16:26
 */
@Data
public class CouponAddRequestDTO {
    /**
     * 优惠券类型：1现金券
     */
    @NotEmpty(message = "优惠券类型不可传空")
    private String couponType;
    /**
     * 优惠券名称
     */
    @NotEmpty(message = "优惠券名称不可传空")
    private String couponName;
    /**
     * 优惠券数量
     */
    @NotNull(message = "优惠券数量不可传空")
    private Integer couponAmount;
    /**
     * 优惠券面值
     */
    @NotNull(message = "优惠券面值不可传空")
    private BigDecimal couponValue;
    /**
     * 最高取现额度
     */
    @NotNull(message = "最高取现额度不可传空")
    private BigDecimal highLimitCash;
    /**
     * 最低取现金额
     */
    @NotNull(message = "最低取现金额不可传空")
    private BigDecimal lowerLimitCash;
    /**
     * 有效期类型 1 按时间范围 2 按天数
     */
    @NotNull(message = "有效期类型不可传空")
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
     * 支持前置科目 0 支持所有 1保险费 2风险保障费 3会员费用
     */
    @NotEmpty(message = "支持前置科目不可传空")
    private String supportSubjects;
    /**
     * 支持产品
     */
    @NotEmpty(message = "支持产品不可传空")
    private String supportProductCode;
    /**
     * 借款期数
     */
    @NotEmpty(message = "借款期数不可传空")
    private String loanPeriods;
    /**
     * 发放截止日期
     */
    @NotEmpty(message = "发放截止日期不可传空")
    private String couponDeadlineDate;
    /**
     * 1被动领取、2主动领取
     */
    @NotNull(message = "领取方式不可传空")
    private Integer distributeType;
    /**
     * 使用说明
     */
    @NotEmpty(message = "使用说明不可传空")
    private String description;
}
