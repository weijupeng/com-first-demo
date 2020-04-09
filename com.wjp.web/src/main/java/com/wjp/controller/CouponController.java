package com.wjp.controller;

import com.vmc.api.req.CouponAddRequestDTO;
import com.vmc.api.req.CouponEditRequestDTO;
import com.vmc.api.req.CouponListRequestDTO;
import com.wjp.common.Result;
import com.wjp.service.coupon.CouponService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wjp
 * @date 2019/12/5 16:22
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

    @PostMapping("/add")
    public Result addCoupon(@Validated @RequestBody CouponAddRequestDTO dto) {
        return couponService.addCoupon(dto);
    }

    @PostMapping("/edit")
    public Result editCoupon(@Validated @RequestBody CouponEditRequestDTO dto) {
        return couponService.editCoupon(dto);
    }

    @GetMapping("update-status/{couponId}")
    public Result updateStatus(@PathVariable("couponId") Long couponId) {
        return couponService.updateStatus(couponId);
    }

    @PostMapping("list")
    public Result list(@Validated @RequestBody CouponListRequestDTO dto) {
        return couponService.list(dto);
    }

}
