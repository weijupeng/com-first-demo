package com.wjp.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author weijupeng
 */
@Component
@ConfigurationProperties(prefix = "package")
@Data
public class UserInfo {
    private String name;
    private Integer age;

}
