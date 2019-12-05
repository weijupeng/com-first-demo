package com.wjp.controller;

import com.wjp.aop.annotation.MyLog;
import com.wjp.common.Result;
import com.wjp.service.enumcode.enumservice.EnumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wjp
 * @date 2019/11/12 16:57
 */
@RestController
@RequestMapping("enum")
public class EnumController {
    @Resource
    private EnumService enumService;

    @MyLog()
    @GetMapping("/{type}")
    public Result getEnumList(@PathVariable String type) {
        return enumService.getEnumList(type);
    }

    @MyLog
    @GetMapping("/test")
    public Result get() {
        return Result.successResult(null);
    }

}
