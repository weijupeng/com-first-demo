package com.wjp.service;

import lombok.Data;

/**
 * @author wjp
 * @date 2019/11/8 18:02
 */
@Data
public class RequestDto {
    private String productCode;
    private String orderId;
    private String vbsBid;
}
