package com.wjp.controller;

import com.wjp.common.demo.FastjsonTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author weijupeng
 */
@RestController
public class TestController {
    @GetMapping("/fast/json")
    public FastjsonTest getFastJson() {
        FastjsonTest fastjsonTest = new FastjsonTest();
        fastjsonTest.setDate(new Date());
        fastjsonTest.setId(1);
        fastjsonTest.setIgnore("13d");
        fastjsonTest.setString("fast");
        return fastjsonTest;
    }
}
