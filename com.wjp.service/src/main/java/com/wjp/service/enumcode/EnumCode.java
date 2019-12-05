package com.wjp.service.enumcode;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wjp
 * @date 2019/11/12 17:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_enum_code")
public class EnumCode {
    @TableId
    private Long id;

    private String enumType;

    private String enumCode;

    private Integer codeType;

    private String enumName;

    private String enumDescription;

    private String enumAttribute;

    private Integer status;

    private Integer sortNo;

    private Integer isDelete;
}