package com.wjp.api.resp;

import lombok.Data;

@Data
public class UserResponseVO {
    private Long id;

    private String userName;

    private String userDes;

    private Integer userAge;

    private Integer isDelete;


}
