package com.wjp.api.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * UserAddRequestDTO
 *
 * @author wjp
 */
@Data
public class UserAddRequestDTO {
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;
    /**
     * 用户描述
     */
    @NotNull(message = "用户描述不能为空")
    private String userDes;
    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;
    /**
     * 是否删除
     */
    private Integer isDelete;
}
