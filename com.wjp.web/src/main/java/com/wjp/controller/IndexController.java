package com.wjp.controller;

import com.wjp.dao.shiro.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weijupeng
 */
@RestController
public class IndexController {
    /**
     * 首页，并将登录用户的全名返回前台
     *
     * @param model mvc
     * @return String
     */
    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("userName", sysUser.getFullName());
        return "index";
    }
}
