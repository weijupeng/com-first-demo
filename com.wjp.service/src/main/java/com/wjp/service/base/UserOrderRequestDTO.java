package com.wjp.service.base;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author weijupeng
 */
@Data
public class UserOrderRequestDTO {
    /**
     * 产品代码
     */
    @NotNull(message = "产品代码不能为空")
    private String productCode;
    /**
     * 业务号
     */
    private String vbsBid;
    /**
     * 用户信息
     */
    private String userInfo;
}
