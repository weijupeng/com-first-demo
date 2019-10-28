package com.wjp.service.base;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author weijupeng
 */
@Data
public class UserOrderInfoResponseVO {
    /**
     * 姓名
     */
    private String userName;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 客户等级
     */
    private Integer customerLevel;
    /**
     * 客户标签
     */
    private String customerLabel;
    /**
     * 授信状态
     */
    private String creditState;
    /**
     * 授信金额
     */
    private BigDecimal creditAmount;
    /**
     * 授信时间
     */
    private String creditTime;
    /**
     * 订单信息
     */
    private List<OrderInfo> orderInfos;

}
