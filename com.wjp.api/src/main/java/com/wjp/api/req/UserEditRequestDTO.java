package com.wjp.api.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * UserEditRequestDTO
 *
 * @author wjp
 */
@Data
public class UserEditRequestDTO {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long id;
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
