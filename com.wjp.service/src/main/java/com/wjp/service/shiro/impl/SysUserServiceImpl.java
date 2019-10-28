package com.wjp.service.shiro.impl;

import com.wjp.dao.shiro.dao.SysUserDao;
import com.wjp.dao.shiro.entity.SysUser;
import com.wjp.service.shiro.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author weijupeng
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public SysUser findByUserName(String username) {
        return sysUserDao.findByUserName(username);
    }

}
