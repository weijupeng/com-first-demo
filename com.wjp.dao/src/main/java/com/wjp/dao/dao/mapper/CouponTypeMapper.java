package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.CouponType;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface CouponTypeMapper extends SuperMapper<CouponType> {

    int insertSelective(CouponType record);
}