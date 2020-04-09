package com.wjp.test.distinct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * </p>
 * @author cailin
 * @since 2020/3/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionOriginalInfo {
    /**
     * 集合名称
     */
    public static final String MONGO_COLLECTION_NAME = "promotion_original_info";
    /**
     * 发起id
     */
    private Long originalId;
    /**
     * 产品
     */
    private String productCode;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 来源
     */
    private Integer promoteSource;
    /**
     * 步骤
     */
    private String step;
    /**
     * 业务id
     */
    private String businessId;
    /**
     * 接口端原始入参json字符串
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 记录是否有效 0否1是
     */
    private Integer isValid;

    /**
     * 状态 1成功 2异常 默认1
     */
    private Integer status;

    /**
     * 异常原因
     */
    private String exceptionReason;
}
