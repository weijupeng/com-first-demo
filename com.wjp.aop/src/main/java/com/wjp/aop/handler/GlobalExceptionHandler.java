package com.wjp.aop.handler;

import com.wjp.aop.exception.CodeException;
import com.wjp.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = CodeException.class)
    public Result defaultErrorHandler(HttpServletRequest req, CodeException e) throws Exception {
        Result error = Result.valueOf("9999", e.getMessage());
        return error;
    }
}
