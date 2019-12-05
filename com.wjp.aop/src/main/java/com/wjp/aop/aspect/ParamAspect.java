package com.wjp.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.wjp.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author wjp
 * @date 2019/11/14 15:53
 */
@Slf4j
@Aspect
@Component
public class ParamAspect {


    private final static String PARENTHESIS = "[]";
    private final static String BRACES = "{}";

    @Pointcut("@annotation(com.wjp.aop.annotation.MyLog)")
    public void doCheck() {
    }

    @AfterReturning(value = "doCheck()", returning = "object")
    public void doAfterReturning(Object object) {
        Result result = (Result) object;

        Object data = result.getData();
        if (Objects.isNull(data)) {
            return;
        }

        Class<?> aClass = data.getClass();


        String s = JSON.toJSONString(result.getData());
        boolean aBoolean = PARENTHESIS.equals(s) | BRACES.equals(s);
        if (result.getSuccess() && !aBoolean) {
            //todo 加密身份证
            System.out.println("进行脱敏");
        }

    }
}
