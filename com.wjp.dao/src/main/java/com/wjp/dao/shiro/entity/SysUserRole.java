package com.wjp.dao.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("sys_user_role")
public class SysUserRole {
    @TableId
    private Long userId;

    private Long roleId;

}