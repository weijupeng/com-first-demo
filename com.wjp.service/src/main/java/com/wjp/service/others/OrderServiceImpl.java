//package com.wjp.service.others;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONPath;
//import com.wjp.common.Result;
//import com.wjp.common.enums.BaseEnum;
//import org.springframework.beans.BeanUtils;
//
///**
// * @author wjp
// * @date 2019/11/8 18:02
// */
//public class OrderServiceImpl {
//
//    private final static String VBS_URL = "";
//    private final static String VFBP_URL = "";
//    private final static Integer SUCCESS_CODE = 1;
//
//    public Result go(RequestDto dto) {
//
//        String s = OkHttpUtil.sendPostJsonObject(VFBP_URL, dto);
//        JSONObject object = JSONObject.parseObject(s);
//        Object data = object.get("data");
//        VbsRequestDto vbsRequestDto = new VbsRequestDto();
//        BeanUtils.copyProperties(dto, vbsRequestDto);
//        String result = OkHttpUtil.sendPostJsonObject(VBS_URL, vbsRequestDto);
//        JSONObject jsonObject = JSONObject.parseObject(result);
//        if (!jsonObject.containsKey("code") || SUCCESS_CODE.equals(jsonObject.get("code"))) {
//            return Result.error(BaseEnum.REMOTE_API_CALL_FAILED.getCode(), "vbs返回结果错误");
//        }
//        Object o = jsonObject.get("data");
//        JSONPath.set(data, "contractInfos", o);
//
//        return Result.successResult(data);
//    }
//}
