package com.wjp.dao.shiro.mapper;

import com.wjp.dao.mapper.SupperMapper;
import com.wjp.dao.shiro.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface SysRolePermissionMapper extends SupperMapper<SysRolePermission> {
    int deleteByPrimaryKey(SysRolePermission key);

    int insertSelective(SysRolePermission record);
}