package com.wjp.controller;


import com.wjp.aop.annotation.UserLog;
import com.wjp.api.req.UserAddRequestDTO;
import com.wjp.api.req.UserEditRequestDTO;
import com.wjp.common.Result;
import com.wjp.service.system.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author wjp
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @UserLog(value = "请求查询用户接口")
    @GetMapping("/query/{userId}")
    public Result query(@PathVariable("userId") Long userId) {
        return userService.query(userId);
    }

    @PostMapping("add")
    public Result addUser(@Validated @RequestBody UserAddRequestDTO user) {
        return userService.addUser(user);
    }

    @PostMapping("edit")
    public Result editUser(@Validated @RequestBody UserEditRequestDTO dto) {
        return userService.editUser(dto);
    }
}
