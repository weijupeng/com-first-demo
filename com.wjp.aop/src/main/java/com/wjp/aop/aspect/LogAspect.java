package com.wjp.aop.aspect;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    private static final ThreadLocal<Long> timeThreadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.wjp.aop.annotation.UserLog)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        timeThreadLocal.set(System.currentTimeMillis());
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求到的request
        HttpServletRequest request = attributes.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取请求的方法
        Method method = methodSignature.getMethod();
        //获取方法名
        String methodName = method.getName();
        log.info("AOP begin ,请求开始方法:{}", method.getDeclaringClass() + "." + methodName + "()");
        //对请求参数进行解析
        String keyValue = getReqParameter(request);
        log.info("请求url = {}", request.getRequestURL().toString());
        log.info("请求方法requestMethod = {}", request.getMethod());
        log.info("请求资源uri = {}", request.getRequestURI());
        log.info("所有的请求参数 key：value = {}", keyValue);
    }

    @After("pointcut()")
    public void after() {
        log.info("aop的after()方法");
    }

    @AfterReturning(returning = "result", pointcut = "pointcut()")
    public Object afterReturn(Object result) {
        log.info("AOP afterReturn,返回值result={}", result.toString());
        Long startTime = timeThreadLocal.get();
        Long callTime = System.currentTimeMillis() - startTime;
        log.info("调用controller花费时间time = {}s", callTime);
        return result;
    }

    private String getReqParameter(HttpServletRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }
        Enumeration<String> enumeration = request.getParameterNames();
        JSONArray jsonArray = new JSONArray();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            JSONObject json = new JSONObject();
            json.put(key, value);
            jsonArray.add(json);
        }
        return jsonArray.toString();
    }

    private Map<String, Object> getParameterMap(HttpServletRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }
        Enumeration<String> enumeration = request.getParameterNames();
        HashMap<String, Object> parameterMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            String keyValue = key + ":" + value + ";";
            stringBuilder.append(keyValue);
            parameterMap.put(key, value);
        }
        return parameterMap;
    }


}
