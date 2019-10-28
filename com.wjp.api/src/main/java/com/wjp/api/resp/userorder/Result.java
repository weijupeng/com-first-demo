package com.wjp.api.resp.userorder;

import lombok.Getter;

/**
 * @author kancy
 * @version 1.0
 * @date 2019/1/30 13:14
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

    private Result(Boolean success, BaseEnum baseEnum) {
        this.success = success;
        this.code = baseEnum.getCode();
        this.message = baseEnum.getMessage();
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


    public static Result valueOf(Boolean success, String code, String message) {
        return new Result(success, code, message);
    }

    public static Result success(String code, String message) {
        return new Result(true, code, message);
    }

    public static Result success() {
        return new Result(true, BaseEnum.SYS_SUCCESS);
    }

    public static Result error(String code, String message) {
        return new Result(false, code, message);
    }

    public static Result error(BaseEnum baseEnum) {
        return new Result(false, baseEnum);
    }

    public static Result error() {
        return new Result(false, BaseEnum.SYS_ERROR);
    }

    /**
     * 正常返回，带有返回体
     *
     * @param data 返回对象
     * @return Result<T>
     */
    public static <T> Result<T> successResult(T data) {
        return success().setData(data);
    }

    /**
     * 异常返回，带有返回体
     *
     * @param data     需要返回的对象
     * @param baseEnum 异常枚举
     * @return Result<T>
     */
    public static <T> Result<T> errorResult(T data, BaseEnum baseEnum) {
        return error(baseEnum).setData(data);
    }
}
