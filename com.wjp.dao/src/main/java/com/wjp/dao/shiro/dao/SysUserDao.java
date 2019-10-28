package com.wjp.dao.shiro.dao;

import com.wjp.dao.base.SuperDao;
import com.wjp.dao.shiro.entity.SysUser;
import com.wjp.dao.shiro.mapper.SysUserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author weijupeng
 */
@Repository
public class SysUserDao extends SuperDao<SysUserMapper, SysUser> {
    public SysUser findByUserName(String username) {
        return baseMapper.findByUserName(username);
    }
}
