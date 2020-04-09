package com.wjp.test.promotion.dto;

import lombok.Data;

/**
 * <p>
 * PromotionRequestDTO
 * <p>
 **/
@Data
public abstract class PromotionRequestDTO {
    /**
     * 产品代码
     */
    private String productCode;
    /**
     * 当前步骤
     */
    private String step;

    /**
     * 来源
     */
    private Integer promoteSource;

    /**
     * 用户中心注册id
     */
    private Long registerId;

    /**
     * 产品中心业务id
     */
    private Long businessId;

    /**
     * ab test 前置标签
     */
    private String frontLabel;
}
