package com.wjp.service.coupon.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vmc.api.other.PageInfo;
import com.vmc.api.other.PageResultBasicModel;
import com.vmc.api.req.CouponAddRequestDTO;
import com.vmc.api.req.CouponEditRequestDTO;
import com.vmc.api.req.CouponListRequestDTO;
import com.vmc.api.resp.CouponListResponseVO;
import com.wjp.common.Result;
import com.wjp.dao.dao.dao.CouponCashDao;
import com.wjp.dao.dao.dao.CouponDao;
import com.wjp.dao.dao.entity.Coupon;
import com.wjp.dao.dao.entity.CouponCash;
import com.wjp.service.coupon.CouponService;
import com.wjp.service.coupon.CouponServiceValidator;
import com.wjp.service.coupon.enums.CouponStatusEnum;
import com.wjp.service.coupon.enums.CouponTypeEnum;
import com.wjp.service.coupon.enums.DistributeTypeEnum;
import com.wjp.service.coupon.enums.SupportSubjectEnum;
import com.wjp.service.https.CommonParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wjp
 * @date 2019/12/6 10:13
 */
@Service
@Slf4j
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponDao couponDao;
    @Resource
    private CouponCashDao couponCashDao;
    @Resource
    private CouponServiceValidator validator;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addCoupon(CouponAddRequestDTO dto) {
        //参数校验
        validator.checkCouponType(dto.getCouponType());
        validator.checkSupportSubjects(dto.getSupportSubjects());
        validator.checkProductCode(dto.getSupportProductCode());
        validator.checkDistribute(dto.getDistributeType());
        validator.checkValidType(dto.getValidType(), dto.getValidDays(), dto.getValidTimeRange());
        validator.checkLoanPeriods(dto.getLoanPeriods());

        //新增到优惠券表
        long couponId = IdWorker.getId();
        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(dto, coupon);
        coupon.setId(couponId);
        couponDao.insertSelective(coupon);

        //新增到现金券表
        if (CouponTypeEnum.CASH.getCouponType().equals(coupon.getCouponType())) {
            CouponCash couponCash = new CouponCash();
            BeanUtils.copyProperties(dto, couponCash);
            couponCash.setCouponId(couponId);
            couponCash.setId(IdWorker.getId());
            couponCashDao.insertSelective(couponCash);
        }
        return Result.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result editCoupon(CouponEditRequestDTO dto) {
        //参数校验
        validator.checkSupportSubjects(dto.getSupportSubjects());

        //获取优惠券基础数据并修改
        Coupon coupon = couponDao.getCouponById(dto.getCouponId());
        Assert.isTrue(Objects.nonNull(coupon), "该优惠券不存在或已下架");
        coupon.setCouponAmount(dto.getCouponAmount());
        couponDao.updateById(coupon);

        //获取现金券数据并修改
        if (CouponTypeEnum.CASH.getCouponType().equals(coupon.getCouponType())) {
            CouponCash couponCash = couponCashDao.getByCouponId(dto.getCouponId());
            Assert.isTrue(Objects.nonNull(couponCash), "该现金券不存在");
            couponCash.setSupportSubjects(dto.getSupportSubjects());
            couponCashDao.updateById(couponCash);
        }

        return Result.success();
    }

    /**
     * 下架
     *
     * @param couponId 优惠券ID
     * @return result
     */
    @Override
    public Result updateStatus(Long couponId) {
        //修改基础表
        Coupon coupon = couponDao.getCouponById(couponId);
        Assert.isTrue(Objects.nonNull(coupon), "该优惠券不存在或已下架");
        coupon.setStatus(CommonParam.ZERO);
        couponDao.updateById(coupon);

        //修改现金券表
        if (CouponTypeEnum.CASH.getCouponType().equals(coupon.getCouponType())) {
            CouponCash couponCash = couponCashDao.getByCouponId(couponId);
            if (Objects.nonNull(couponCash)) {
                couponCash.setIsDeleted(CommonParam.ONE);
                couponCashDao.updateById(couponCash);
            }
        }
        return Result.success();
    }

    @Override
    public Result list(CouponListRequestDTO dto) {
        //参数校验
        validator.checkProductCode(dto.getSupportProductCode());
        validator.checkCouponType(dto.getCouponType());
        if (Objects.nonNull(dto.getStatus())) {
            validator.checkStatus(dto.getStatus());
        }

        //获取优惠券列表
        IPage<Coupon> page = getCouponPage(dto);

        List<Coupon> records = page.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return Result.success();
        }

        //转换成返回格式
        List<CouponListResponseVO> responseList = records.stream().map(a -> {
            CouponListResponseVO vo = new CouponListResponseVO();
            BeanUtils.copyProperties(a, vo);
            vo.setDistributeTypeDesc(DistributeTypeEnum.getDesc(a.getDistributeType()));
            vo.setStatusDesc(CouponStatusEnum.getDesc(a.getStatus()));
            vo.setCouponTypeDesc(CouponTypeEnum.getDesc(a.getCouponType()));
            vo.setCouponId(a.getId());
            return vo;
        }).collect(Collectors.toList());

        //获取优惠券ID集合
        Set<Long> couponIds = responseList.stream().map(CouponListResponseVO::getCouponId).collect(Collectors.toSet());
        if (CouponTypeEnum.CASH.getCouponType().equals(dto.getCouponType())) {
            //获取现金券列表
            List<CouponCash> couponCashes = couponCashDao.getByCouponIds(couponIds);
            responseList.forEach(a -> {
                Optional<CouponCash> first = couponCashes.stream().filter(b -> b.getCouponId().equals(a.getCouponId())).findFirst();
                if (first.isPresent()) {
                    a.setCouponValue(first.get().getCouponValue());
                    a.setSupportSubjects(first.get().getSupportSubjects());
                    a.setSupportSubjectsDesc(SupportSubjectEnum.getDesc(first.get().getSupportSubjects()));
                    a.setLowerLimitCash(first.get().getLowerLimitCash());
                    a.setLoanPeriods(first.get().getLoanPeriods());
                }
            });
        }
        PageInfo<Object> pageInfo = new PageResultBasicModel<Coupon, CouponListResponseVO>().createPageInfo(page, responseList);
        return Result.successResult(pageInfo);
    }


    private IPage<Coupon> getCouponPage(CouponListRequestDTO dto) {
        LambdaQueryWrapper<Coupon> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(Coupon::getSupportProductCode, dto.getSupportProductCode());
        lambdaQuery.eq(Coupon::getCouponType, dto.getCouponType());
        lambdaQuery.eq(Coupon::getIsDeleted, 0);
        lambdaQuery.orderByDesc(Coupon::getCreatedTime);
        if (Objects.nonNull(dto.getStatus())) {
            lambdaQuery.eq(Coupon::getStatus, dto.getStatus());
        }
        Page<Coupon> page = new Page<>(dto.getCurrentPage(), dto.getPageSize());
        page.setSearchCount(true);
        return couponDao.page(page, lambdaQuery);
    }
}