package com.wjp.dao.shiro.mapper;

import com.wjp.dao.mapper.SupperMapper;
import com.wjp.dao.shiro.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author weijupeng
 */
@Mapper
public interface SysUserMapper extends SupperMapper<SysUser> {
    int deleteByPrimaryKey(Long userId);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     *
     * @return SysUser
     */
    SysUser findByUserName(@Param("username") String username);
}