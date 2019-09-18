package com.wjp.common;

import com.wjp.common.enums.BaseEnum;
import lombok.Getter;

/**
 * @author kancy
 * @version 1.0
 */
@Getter
public class Result<T> extends BaseModel {

    private Boolean success;
    private String code;
    private String message;
    private Long timestamp = System.currentTimeMillis();
    private T data;

    protected Result() {

    }

    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }


    private Result(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(Boolean success, BaseEnum baseEnum) {
        this.success = success;
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
    }

    public static Result valueOf(Boolean success, String code, String message) {
        return new Result(success, code, message);
    }

    public static Result valueOf(String code, String message) {
        return new Result(code, message);
    }

    public static Result success(String code, String message) {
        return new Result(true, code, message);
    }

    public static Result error(String code, String message) {
        return new Result(code, message);
    }


    public static Result error(BaseEnum baseEnum) {
        return new Result(false, baseEnum.getCode(), baseEnum.getMessage());
    }

    public static Result success() {
        return new Result(true, BaseEnum.SYS_SUCCESS);
    }

    public static <T> Result successResult(T data) {
        return Result.success().setData(data);
    }

    public Result setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

}
