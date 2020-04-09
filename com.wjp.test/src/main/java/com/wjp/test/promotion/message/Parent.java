package com.wjp.test.promotion.message;


import lombok.Data;

import java.util.List;

/**
 * @author wjp
 * @date 2020/3/5 18:49
 */
@Data
public class Parent {
    private List<Child> children;
    private String name;


}
