package com.wjp.api.resp.userorder;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author weijupeng
 */
public class DemoClass {
    public static void main(String[] args) {
        ArrayList<UserOrderInfoResponseVO> vos = new ArrayList<>();
        UserOrderInfoResponseVO info = setUserInfo();
        vos.add(info);
        vos.add(info);

        System.out.println(Result.successResult(vos));
    }

    private static UserOrderInfoResponseVO setUserInfo() {
        UserOrderInfoResponseVO responseVO = new UserOrderInfoResponseVO();
        responseVO.setCreditState("授信失效");
        responseVO.setCreditTime("2018-05-24 19:00");
        responseVO.setCustomerLabel("333客户");
        responseVO.setCustomerLevel(1);
        responseVO.setIdNo("430528197812012598");
        responseVO.setMobile("18901652537");
        responseVO.setUserName("刘程飞");
        ArrayList<OrderInfo> orderInfos = setOrderInfo();
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
        orderInfo.setLoanAmount(decimal);
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
        orderInfo2.setLoanAmount(decimal2);
        orderInfo2.setLoanType("再贷");
        orderInfo2.setOrderId("15246489");
        orderInfo2.setState("还款完成");
        orderInfo2.setVbsBid("1564879");
        orderInfos.add(orderInfo2);


        return orderInfos;
    }
}
