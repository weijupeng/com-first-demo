package com.wjp.dao.shiro.mapper;

import com.wjp.dao.mapper.SupperMapper;
import com.wjp.dao.shiro.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weijupeng
 */
@Mapper
public interface SysPermissionMapper extends SupperMapper<SysPermission> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    /**
     * 获取用户权限列表
     *
     * @param userId 用户ID
     *
     * @return List<String>
     */
    List<String> selectPermissionByUserId(@Param("userId") Long userId);
}