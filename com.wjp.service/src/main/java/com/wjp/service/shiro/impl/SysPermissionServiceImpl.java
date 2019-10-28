package com.wjp.service.shiro.impl;

import com.wjp.dao.shiro.dao.SysPermissionDao;
import com.wjp.service.shiro.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weijupeng
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao permissionDao;

    /**
     * 获取用户权限列表
     *
     * @param userId 用户ID
     *
     * @return List<String>
     */
    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        return permissionDao.selectPermissionByUserId(userId);
    }
}
