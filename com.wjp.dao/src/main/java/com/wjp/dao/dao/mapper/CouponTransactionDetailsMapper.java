package com.wjp.dao.dao.mapper;

import com.wjp.dao.dao.entity.CouponTransactionDetails;
import com.wjp.dao.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface CouponTransactionDetailsMapper extends SuperMapper<CouponTransactionDetails> {

    int insertSelective(CouponTransactionDetails record);
}