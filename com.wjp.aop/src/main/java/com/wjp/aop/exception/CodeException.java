package com.wjp.aop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeException extends RuntimeException {

    private String code;
    private String message;

}
