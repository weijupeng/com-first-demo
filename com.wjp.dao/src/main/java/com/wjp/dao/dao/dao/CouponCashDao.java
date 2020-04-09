package com.wjp.dao.dao.dao;

import com.wjp.dao.base.SuperDao;
import com.wjp.dao.dao.entity.CouponCash;
import com.wjp.dao.dao.mapper.CouponCashMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author wjp
 * @date 2019/12/5 16:08
 */
@Repository
public class CouponCashDao extends SuperDao<CouponCashMapper, CouponCash> {
    public void insertSelective(CouponCash couponCash) {
        baseMapper.insertSelective(couponCash);
    }

    public CouponCash getByCouponId(Long couponId) {
        return baseMapper.getByCouponId(couponId);
    }

    public List<CouponCash> getByCouponIds(Set<Long> couponIds) {
        return baseMapper.getByCouponIds(couponIds);
    }
}
