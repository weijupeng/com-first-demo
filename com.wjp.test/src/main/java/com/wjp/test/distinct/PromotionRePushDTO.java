package com.wjp.test.distinct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wjp
 * @date 2020/4/8 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionRePushDTO {
    /**
     * 用户中心注册id
     */
    private Integer registerId;
    /**
     * 重试阶段
     */
    private Integer errorStage;
    /**
     * 来源
     * @see com.vcredit.vmc.enums.PromoteSourceEnum
     */
    private String promoteSource;

}
