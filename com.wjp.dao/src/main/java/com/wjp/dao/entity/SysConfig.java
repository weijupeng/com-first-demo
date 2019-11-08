package com.wjp.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wjp
 * @date 2019/11/1 11:07
 */
@Data
@TableName("t_sys_config")
public class SysConfig {
    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 配置名
     */
    private String configName;
    /**
     * 配置的值
     */
    private String configValue;
    /**
     * 配置描述
     */
    private String configDesc;
    /**
     * 是否删除（1：是 0：否）
     */
    private Integer isDelete;

}
