package com.wjp.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wjp
 * @date 2019/12/17 15:25
 */
@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String password;
    private String age;
}
