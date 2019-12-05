//package com.wjp.service.https;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.wjp.common.Result;
//import com.wjp.common.enums.BaseEnum;
//import com.wjp.service.others.OkHttpUtil;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.HashMap;
//
///**
// * @author wjp
// * @date 2019/11/12 15:23
// */
//public class HttpUtils {
//
//    private final static String URL = "http://localhost:9587/supplier/query/list";
//    private final static String CODE = "code";
//
//    public void sendRequest() {
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(HttpUtils.go().getData());
//
//    }
//
//    public static String getToken() {
//        return null;
//    }
//
//
//    public static Result go() {
//        HashMap<String, String> postMap = new HashMap<>(16);
//        postMap.put("orderId", "123456");
//        String result = OkHttpUtil.sendGet(URL);
//        if (StringUtils.isEmpty(result)) {
//            return Result.error(BaseEnum.REMOTE_API_CALL_FAILED.getCode(), "vbs接口返回为null");
//        }
//        JSONObject jsonObject = JSONObject.parseObject(result);
//        if (!jsonObject.containsKey("success") || CommonParam.ZERO.equals(jsonObject.getBoolean("success"))) {
//            return Result.error(BaseEnum.REMOTE_API_CALL_FAILED.getCode(), "vbs接口返回错误");
//        }
//        Object data = jsonObject.get("data");
//        String s = JSON.toJSONString(data);
//        return Result.successResult(s);
//    }
//
//}
