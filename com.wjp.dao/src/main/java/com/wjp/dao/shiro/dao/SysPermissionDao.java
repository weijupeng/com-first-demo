package com.wjp.dao.shiro.dao;

import com.wjp.dao.base.SuperDao;
import com.wjp.dao.shiro.entity.SysPermission;
import com.wjp.dao.shiro.mapper.SysPermissionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysPermissionDao extends SuperDao<SysPermissionMapper, SysPermission> {
    /**
     * 获取用户权限列表
     *
     * @param userId 用户ID
     *
     * @return List<String>
     */
    public List<String> selectPermissionByUserId(Long userId) {
        return baseMapper.selectPermissionByUserId(userId);
    }
}
