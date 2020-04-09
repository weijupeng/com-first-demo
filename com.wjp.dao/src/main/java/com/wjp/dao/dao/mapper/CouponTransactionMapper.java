package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.CouponTransaction;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface CouponTransactionMapper extends SuperMapper<CouponTransaction> {

    int insertSelective(CouponTransaction record);
}