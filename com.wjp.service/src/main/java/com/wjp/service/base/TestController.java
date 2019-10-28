package com.wjp.service.base;

import com.wjp.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author weijupeng
 */
@RestController
public class TestController {
    @GetMapping("/credit")
    public Result test2() {
        HashMap<String, Object> map = new HashMap<>(2);
        BaseInfo baseInfo = setBaseInfo();
        CreditInfo creditInfo = setCreditInfo();
        map.put("baseInfo", baseInfo);
        map.put("creditInfo", creditInfo);
        return Result.successResult(map);
    }

    @GetMapping("/order")
    public Result test3() {
        HashMap<String, Object> map = new HashMap<>(3);
        BaseInfo baseInfo = setBaseInfo();
        CreditInfo creditInfo = setCreditInfo();
        OrderBaseInfo orderBaseInfo = setOrder();
        BankCard bankCard = setBankCards();
        List<ContractInfo> contractInfos = setContractInfos();
        setContractInfos();
        map.put("baseInfo", baseInfo);
        map.put("creditInfo", creditInfo);
        map.put("orderBaseInfo", orderBaseInfo);
        map.put("bankCard", bankCard);
        map.put("contractInfos", contractInfos);
        return Result.successResult(map);
    }

    private OrderBaseInfo setOrder() {
        return OrderBaseInfo.builder().status("审核中").agencyTime("2019-10-10 00：00").agencyAmount(BigDecimal.valueOf(20000))
                .loanPeriods(6).monthRate("1.797%").loanTime("").loanType("首贷").monthRateLevel("高费率")
                .fundName(" 陕西长银消金股份有限公司")
                .build();
    }

    private List<ContractInfo> setContractInfos() {
        ArrayList<ContractInfo> contractInfos = new ArrayList<>();
        contractInfos.add(ContractInfo.builder().contractName("委托扣款协议书").contractUrl("委托扣款协议书url").build());
        contractInfos.add(ContractInfo.builder().contractName("个人信用信息查询及提供授权书").contractUrl("个人信用信息查询及提供授权书url").build());
        return contractInfos;
    }

    private BankCard setBankCards() {
        return BankCard.builder().loanCardBank("浦东发展银行").loanCardNo("6212261049019847389").loanCardType("借记卡")
                .repaymentCardBank("中国中兴银行").loanCardNo("6212261049019847389").repaymentCardType("贷记卡")
                .build();
    }


    private CreditInfo setCreditInfo() {
        return CreditInfo.builder().creditTime("2019-09-10 12：00").customerAllLines(BigDecimal.valueOf(20000))
                .availableLines(BigDecimal.valueOf(10000)).customerLabel("正常客户")
                .customerLevel(1).customerSupplementLabel("优质客户").linesExpirationTime("2019-12-30 00：00")
                .reportChannel("外贸征信").build();
    }

    private BaseInfo setBaseInfo() {
        HashMap<String, String> idCardPictues = new HashMap<>();
        idCardPictues.put("frontImg", "zhengmianzhaourl");
        idCardPictues.put("backImg", "fanminzhaourl");
        idCardPictues.put("handImg", "shouchizhaourl");
        idCardPictues.put("liveImg", "huotizhaourl");
        idCardPictues.put("signImg", "qianmingurl");

        return BaseInfo.builder().userName("李子其").idNo("410522199510254444")
                .registerMobile("13805941234").realNameMobile("13805941234")
                .channelName("rong360").birthday("1991-05-20").idCardValidBeginDate("2018-05-23")
                .idCardValidEndDate("2023-05-23")
                .marriage("未婚").education("本科").nation("汉").sex("女")
                .isNumberFeeExpired("否").faceScore(82).publicSecurityMeshScore(88)
                .address("上海市浦东新区大河东路2291号XXX新苑2期42号楼908室")
                .idCardPictures(idCardPictues)
                .build();
    }


    @GetMapping("/res")
    public Result test() {
        UserOrderInfoResponseVO info = setUserInfo();
        return Result.successResult(info);
    }

    private static UserOrderInfoResponseVO setUserInfo() {
        UserOrderInfoResponseVO responseVO = new UserOrderInfoResponseVO();
        responseVO.setCreditState("授信失效");
        responseVO.setCreditTime("2018-05-24 19:00");
        responseVO.setCustomerLabel("333客户");
        responseVO.setCustomerLevel(1);
        responseVO.setCreditAmount(BigDecimal.valueOf(20000.00));
        responseVO.setIdNo("430528197812012598");
        responseVO.setMobile("18901652537");
        responseVO.setUserName("刘程飞");
        List<OrderInfo> orderInfos = setOrderInfo();
        responseVO.setOrderInfos(orderInfos);
        return responseVO;
    }

    private static ArrayList<OrderInfo> setOrderInfo() {
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCashTime("2019-08-10 10：00");
        orderInfo.setFundName("海尔消金");
        orderInfo.setLoadPeriods(3);
        BigDecimal decimal = BigDecimal.valueOf(20000.00);
        orderInfo.setCashAmount(decimal);
        orderInfo.setLoanType("首贷");
        orderInfo.setOrderId("1648898");
        orderInfo.setState("还款完成");
        orderInfo.setVbsBid("4251345");
        orderInfos.add(orderInfo);


        OrderInfo orderInfo2 = new OrderInfo();
        orderInfo2.setCashTime("2019-09-10 12：00");
        orderInfo2.setFundName("汇金20");
        orderInfo2.setLoadPeriods(6);
        BigDecimal decimal2 = BigDecimal.valueOf(10000.00);
        orderInfo2.setCashAmount(decimal2);
        orderInfo2.setLoanType("再贷");
        orderInfo2.setOrderId("15246489");
        orderInfo2.setState("还款完成");
        orderInfo2.setVbsBid("1564879");
        orderInfos.add(orderInfo2);
        return orderInfos;
    }

}
