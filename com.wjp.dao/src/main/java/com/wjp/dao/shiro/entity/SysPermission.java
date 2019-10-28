package com.wjp.dao.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("sys_permission")
public class SysPermission {
    @TableId
    private Long id;

    private Long parentId;

    private String resName;

    private String resType;

    private String permission;

    private String url;

}