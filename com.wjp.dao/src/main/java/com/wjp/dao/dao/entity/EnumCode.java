package com.wjp.dao.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weijupeng
 */
@Data
@TableName("t_code_code")
public class EnumCode {
    @TableId
    private Long id;
    /**
     * 枚举名称
     */
    private String enumName;
    /**
     * 枚举值代码
     */
    private String codeValue;
    /**
     * 枚举值类型 0 字符类型 1 数字类型
     */
    private String codeType;
    /**
     * 枚举值名称
     */
    private String codeName;
    /**
     * 枚举值描述
     */
    private String codeDescription;
    /**
     * 枚举值属性
     */
    private String codeAttribute;
    /**
     * 排序
     */
    private Integer sortNo;
    /**
     * 是否删除 0否 1是
     */
    private Integer isDelete;

}