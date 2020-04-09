package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("t_coupon_type")
public class CouponType {
    @TableId
    private Long id;
    /**
     * 优惠券类型
     */
    private String couponType;
    /**
     * 优惠券类型名称
     */
    private String couponTypeName;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}