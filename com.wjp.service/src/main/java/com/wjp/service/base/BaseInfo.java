package com.wjp.service.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author weijupeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfo {
    /**
     * 姓名
     */
    private String userName;
    /**
     * 身份证号
     */
    private String idNo;
    /**
     * 注册手机号
     */
    private String registerMobile;
    /**
     * 实名手机号
     */
    private String realNameMobile;
    /**
     * 渠道名
     */
    private String channelName;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 证件有效开始日
     */
    private String idCardValidBeginDate;
    /**
     * 证件有效结束日
     */
    private String idCardValidEndDate;
    /**
     * 婚姻状况
     */
    private String marriage;
    /**
     * 最高学历
     */
    private String education;
    /**
     * 民族
     */
    private String nation;
    /**
     * 性别
     */
    private String sex;
    /**
     * 是否会员费过期
     */
    private String isNumberFeeExpired;
    /**
     * 人脸识别分
     */
    private Integer faceScore;
    /**
     * 公安网纹对比分
     */
    private Integer publicSecurityMeshScore;
    /**
     * 客户详细地址
     */
    private String address;
    /**
     * 材料信息(证件照片)
     */
    private Map<String, String> idCardPictures;
}
