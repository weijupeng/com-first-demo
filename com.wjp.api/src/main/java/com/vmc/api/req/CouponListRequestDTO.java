package com.vmc.api.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author wjp
 * @date 2019/12/6 10:10
 */
@Data
public class CouponListRequestDTO {
    /**
     * 优惠券类型：1现金券
     */
    @NotEmpty(message = "优惠券类型不能传空")
    private String couponType;
    /**
     * 支持产品
     */
    @NotEmpty(message = "产品不能传空")
    private String supportProductCode;
    /**
     * 状态:0 下架，1 上架
     */
    private Integer status;

    private Integer currentPage = 1;

    private Integer pageSize = 10;
}
