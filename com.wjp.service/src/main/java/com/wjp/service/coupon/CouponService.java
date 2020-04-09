package com.wjp.service.coupon;

import com.vmc.api.req.CouponAddRequestDTO;
import com.vmc.api.req.CouponEditRequestDTO;
import com.vmc.api.req.CouponListRequestDTO;
import com.wjp.common.Result;

/**
 * @author wjp
 * @date 2019/12/6 10:13
 */
public interface CouponService {
    /**
     * 新增优惠券
     *
     * @param dto 入参
     * @return result
     */
    Result addCoupon(CouponAddRequestDTO dto);

    /**
     * 修改优惠券
     *
     * @param dto 入参
     * @return result
     */
    Result editCoupon(CouponEditRequestDTO dto);

    /**
     * 下架
     *
     * @param couponId 优惠券ID
     * @return return
     */
    Result updateStatus(Long couponId);

    /**
     * 获取优惠券列表
     *
     * @param dto 入参
     * @return return
     */
    Result list(CouponListRequestDTO dto);
}
