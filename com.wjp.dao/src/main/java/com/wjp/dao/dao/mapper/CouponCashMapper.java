package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.CouponCash;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author weijupeng
 */
@Mapper
public interface CouponCashMapper extends SuperMapper<CouponCash> {

    /**
     * 新增
     *
     * @param record 实体
     * @return int
     */
    int insertSelective(CouponCash record);

    /**
     * 通过优惠券ID获取现金券
     *
     * @param couponId 优惠券ID
     * @return CouponCash
     */
    CouponCash getByCouponId(@Param("couponId") Long couponId);

    /**
     * 通过优惠券ID集合查询现金券集合
     *
     * @param couponIds 优惠券ID集合
     * @return 现金券集合
     */
    List<CouponCash> getByCouponIds(@Param("couponIds") Set<Long> couponIds);
}