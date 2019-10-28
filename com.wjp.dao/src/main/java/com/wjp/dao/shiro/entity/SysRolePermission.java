package com.wjp.dao.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("sys_role_permission")
public class SysRolePermission {
    @TableId
    private Long roleId;

    private Long permissionId;

}