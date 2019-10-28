package com.wjp.dao.shiro.mapper;

import com.wjp.dao.mapper.SupperMapper;
import com.wjp.dao.shiro.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface SysUserRoleMapper extends SupperMapper<SysUserRole> {
    int deleteByPrimaryKey(SysUserRole key);

    int insertSelective(SysUserRole record);
}