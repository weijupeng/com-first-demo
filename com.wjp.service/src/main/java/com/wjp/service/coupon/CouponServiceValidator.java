package com.wjp.service.coupon;

import com.wjp.aop.exception.CodeException;
import com.wjp.common.untils.DateUtil;
import com.wjp.service.coupon.enums.*;
import com.wjp.service.coupon.other.HttpResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @author wjp
 * @date 2019/12/6 10:25
 */
@Component
public class CouponServiceValidator {
    private static final String COMMA = ",";

    public void checkCouponType(String couponType) {
        Assert.isTrue(CouponTypeEnum.checkContains(couponType), "券类型输入错误");
        Assert.isTrue(CouponTypeEnum.CASH.getCouponType().equals(couponType), "目前只支持现金券");
    }

    public void checkSupportSubjects(String subjects) {
        String[] split = subjects.split(COMMA);
        for (String s : split) {
            checkSupportSubject(s);
        }
    }


    public void checkSupportSubject(String subject) {
        Assert.isTrue(SupportSubjectEnum.checkContains(subject), "支持前置科目输入错误");
    }

    public void checkProductCode(String productCode) {
        Assert.isTrue(ProductCodeEnum.checkContains(productCode), "产品代码输入错误");
    }

    public void checkDistribute(Integer distributeType) {
        Assert.isTrue(DistributeTypeEnum.checkContains(distributeType), "领取方式输入错误");
    }

    public void checkValidType(Integer type, Integer days, String timeRange) {
        Assert.isTrue(ValidTypeEnum.checkContains(type), "有效期类型输入错误");
        if (ValidTypeEnum.TIMERANGE.getValidType().equals(type)) {
            Assert.isTrue(StringUtils.isNotEmpty(timeRange), "有效时间范围不能传空");
            String[] split = timeRange.split("~");
            try {
                DateUtil.stringToString(split[0], DateUtil.DATE_PATTERN_YYYY_MM_DD, DateUtil.DATE_PATTERN_PATTERN);
                DateUtil.stringToString(split[1], DateUtil.DATE_PATTERN_YYYY_MM_DD, DateUtil.DATE_PATTERN_PATTERN);
            } catch (Exception e) {
                throw new CodeException(HttpResponseCode.PARAM_ERROR, "有效时间范围输入错误");
            }
        } else {
            Assert.isTrue(!Objects.isNull(days), "有效期天数输入不能为空");
        }

    }

    public void checkLoanPeriods(String loanPeriods) {
        String[] split = loanPeriods.split(COMMA);
        for (String s : split) {
            checkLoanPeriod(s);
        }
    }


    public void checkLoanPeriod(String loanPeriod) {
        Assert.isTrue(LoanPeriodEnum.checkContains(loanPeriod), "贷款期数输入错误");
    }


    public void checkStatus(Integer status) {
        Assert.isTrue(CouponStatusEnum.checkContains(status), "优惠券类型输入错误");
    }
}
