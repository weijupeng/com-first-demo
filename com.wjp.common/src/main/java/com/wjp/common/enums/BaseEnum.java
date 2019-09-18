package com.wjp.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum BaseEnum {
    /**
     * 基本枚举
     */
    SYS_ERROR("SYS00001", "系统处理异常"),
    SYS_SUCCESS("SYS00000", "操作成功!"),
    USER_NOT_EXIST("U00001", "用户不存在"),
    ;
    private String code;
    private String message;
}
