package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("t_cust_coupon")
public class CustCoupon {
    @TableId
    private Long id;
    /**
     * 业务线用户ID
     */
    private Long custId;
    /**
     * 优惠券ID
     */
    private Long couponId;
    /**
     * 用户优惠券编号
     */
    private String custCouponNo;
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 操作人
     */
    private String operator;
    /**
     * init 待使用、used 已使用、expired 已过期、frozen 冻结
     */
    private String status;
    /**
     * 是否删除
     */
    private Integer isDeleted;

}