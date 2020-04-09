package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.Coupon;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author weijupeng
 */
@Mapper
public interface CouponMapper extends SuperMapper<Coupon> {
    /**
     * 插入一条数据
     *
     * @param record 实体
     */
    void insertSelective(Coupon record);

    /**
     * c 获取优惠券
     *
     * @param couponId 优惠券ID
     * @return coupon
     */
    Coupon getCouponById(@Param("couponId") Long couponId);
}