package com.vmc.api.req;

import lombok.Data;

/**
 * @author wjp
 * @date 2019/12/6 10:06
 */
@Data
public class CouponEditRequestDTO {
    /**
     * 优惠券ID
     */
    private Long couponId;
    /**
     * 优惠券数量
     */
    private Integer couponAmount;
    /**
     * 支持前置科目 0 支持所有 1保险费 2风险保障费 3会员费用
     */
    private String supportSubjects;
    /**
     * 发放截止日期
     */
    private String couponDeadlineDate;
    /**
     * 使用说明
     */
    private String description;
}
