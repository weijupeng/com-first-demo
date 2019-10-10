package com.wjp.aop.aspect;

import com.wjp.common.Result;
import com.wjp.common.enums.BaseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author weijupeng
 */
@RestControllerAdvice
public class GlobalExceptionAspect {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionAspect.class);

    /**
     * 全局异常抓捕
     *
     * @param e 异常
     *
     * @return Result
     */
    @ExceptionHandler
    public Result handleException(Throwable e) {
        logger.error("GlobalExceptionAspect print Throwable :", e);
        return Result.error("00000", e.getStackTrace()[0].getClassName());
    }

    /**
     * MissingServletRequestParameterException
     *
     * @param e 异常对象
     *
     * @return Result
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("GlobalExceptionAspect print MissingServletRequestParameterException : {}", e.getMessage());
        return Result.error("00000", String.format("参数[%s]输入不合法", e.getParameterName()));
    }

    /**
     * 参数验证异常处理
     *
     * @param ex 异常对象
     *
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.debug("GlobalExceptionAspect print MethodArgumentNotValidException :{}" + ex.getMessage());
        return Result.error(BaseEnum.API_PARAMS_ERROR.getCode(), errorMessage(ex));
    }

    /**
     * 处理异常返回信息
     *
     * @param e 异常
     *
     * @return 描述信息
     */
    private String errorMessage(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder();
        // 只返回一个错误
        if (bindingResult.hasErrors()) {
            ObjectError firstError = bindingResult.getAllErrors().get(0);
            stringBuilder.append(StringUtils.isEmpty(firstError.getDefaultMessage()) ? "param is invalid" : firstError.getDefaultMessage());
        }
        return stringBuilder.toString();
    }

}
