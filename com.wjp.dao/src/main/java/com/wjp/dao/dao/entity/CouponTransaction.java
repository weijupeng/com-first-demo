package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("t_coupon_transaction")
public class CouponTransaction {
    @TableId
    private Long id;
    /**
     * 用户优惠券id
     */
    private Long custCouponId;
    /**
     * 交易类型 BillDeduct、RepaymentDeduct
     */
    private String transactionType;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}