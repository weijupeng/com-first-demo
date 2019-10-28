package com.wjp.service.shiro;

import com.wjp.dao.shiro.entity.SysUser;

/**
 * @author weijupeng
 */
public interface SysUserService {
    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser findByUserName(String username);
}
