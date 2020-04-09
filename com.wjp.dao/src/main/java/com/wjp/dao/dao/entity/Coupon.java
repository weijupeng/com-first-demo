package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author weijupeng
 */
@Data
@TableName("t_coupon")
public class Coupon {
    @TableId
    private Long id;
    /**
     * 优惠券类型：1现金券
     */
    private String couponType;
    /**
     * 优惠券名称
     */
    private String couponName;
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
     * 支持产品
     */
    private String supportProductCode;
    /**
     * 发放截止日期
     */
    private String couponDeadlineDate;
    /**
     * 1被动领取、2主动领取
     */
    private Integer distributeType;
    /**
     * 使用说明
     */
    private String description;
    /**
     * 1 上架 0 下架
     */
    private Integer status;
    /**
     * 是否删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private String createdTime;
    /**
     * 修改时间
     */
    private String updatedTime;

}