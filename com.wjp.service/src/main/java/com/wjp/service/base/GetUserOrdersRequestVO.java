package com.wjp.service.base;

import lombok.Data;

/**
 * @author weijupeng
 */
@Data
public class GetUserOrdersRequestVO {
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 业务号
     */
    private String vbsBid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String idNo;

}
