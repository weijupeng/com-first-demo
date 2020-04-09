package com.wjp.dao.dao.dao;

import com.wjp.dao.base.SuperDao;
import com.wjp.dao.dao.entity.Coupon;
import com.wjp.dao.dao.mapper.CouponMapper;
import org.springframework.stereotype.Repository;

/**
 * @author wjp
 * @date 2019/12/5 16:07
 */
@Repository
public class CouponDao extends SuperDao<CouponMapper, Coupon> {
    public void insertSelective(Coupon coupon) {
        baseMapper.insertSelective(coupon);
    }

    public Coupon getCouponById(Long couponId) {
        return baseMapper.getCouponById(couponId);
    }

}
