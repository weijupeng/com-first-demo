package com.wjp.service.system;


import com.wjp.api.req.UserAddRequestDTO;
import com.wjp.api.req.UserEditRequestDTO;
import com.wjp.common.Result;

/**
 * UserService
 *
 * @author wjp
 */
public interface UserService {
    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return Result
     */
    Result query(Long userId);

    /**
     * 新增用户
     *
     * @param dto 用户信息
     * @return Result
     */
    Result addUser(UserAddRequestDTO dto);

    /**
     * 新增用户
     *
     * @param dto 用户信息
     * @return Result
     */
    Result editUser(UserEditRequestDTO dto);
}
