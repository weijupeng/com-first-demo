package com.wjp.test.promotion.message;

import lombok.Data;

/**
 * <p>
 * AbstractPromotionMessage
 * <p>
 * @author: kancy
 * @date: 2020/3/3 12:36
 **/
@Data
public abstract class AbstractPromotionMessage extends AbstractPollingMessage {
    /**
     * 发起ID
     */
    private Long originalId;
    /**
     * 任务ID
     */
    private Long taskId;
    /**
     * 计划ID
     */
    private Long planId;
    /**
     * 来源
     */
    private Integer promoteSource;
}
