package com.wjp.dao.shiro.mapper;

import com.wjp.dao.mapper.SupperMapper;
import com.wjp.dao.shiro.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author weijupeng
 */
@Mapper
public interface SysRoleMapper extends SupperMapper<SysRole> {
    int deleteByPrimaryKey(Long roleId);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}