package com.wjp.dao.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableId
    private Long userId;

    private String userName;

    private String fullName;

    private String password;

    private String salt;

}