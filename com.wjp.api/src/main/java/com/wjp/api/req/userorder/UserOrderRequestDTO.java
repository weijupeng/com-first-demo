package com.wjp.api.req.userorder;

import lombok.Data;

/**
 * @author weijupeng
 */
@Data
public class UserOrderRequestDTO {

    private String productCode;
    private String vbsBid;
    private String userInfo;
}
