package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.CustCoupon;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface CustCouponMapper extends SuperMapper<CustCoupon> {

    int insertSelective(CustCoupon record);
}