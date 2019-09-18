package com.wjp.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * User
 *
 * @author wjp
 */
@Data
@TableName("t_user")
public class User {
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户描述
     */
    private String userDes;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}