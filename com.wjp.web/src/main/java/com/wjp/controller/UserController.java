package com.wjp.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjp.aop.annotation.UserLog;
import com.wjp.api.req.UserAddRequestDTO;
import com.wjp.api.req.UserEditRequestDTO;
import com.wjp.common.Result;
import com.wjp.dao.entity.User;
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


    @Resource
    private UserInfo userInfo;

    @GetMapping("/hello")
    public String hello() {
        return userInfo.getName() + userInfo.getAge();
    }

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


    @GetMapping("/users")
    public PageInfo<User> lists(@RequestParam(defaultValue = "1") int currentPage,
                                @RequestParam(defaultValue = "0") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(userService.getUsers());
        return userPageInfo;
    }
}
