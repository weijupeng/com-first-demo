package com.wjp.service.coupon.other;

/**
 * @author : Wuxi
 */
public class HttpResponseCode {

    /**
     *  请求参数不正确
     */
    public static final String PARAM_ERROR = "RP00001";
    /**
     *  批量重复执行
     */
    public static final String TASK_REEXECUTE_ERROR = "TR00001";

    /**
     * 第三方接口调用成功返回的响应码
     */
    public static final String  TRIPARTITE_SUCCESS_CODE = "10000";

    /**
     * 豆豆钱正确响应码
     */
    public static final Integer  DDQ_SUCCESS_CODE = 200;
}
