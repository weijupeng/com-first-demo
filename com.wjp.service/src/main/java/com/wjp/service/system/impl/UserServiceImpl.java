package com.wjp.service.system.impl;


import com.wjp.aop.exception.UserException;
import com.wjp.api.req.UserAddRequestDTO;
import com.wjp.api.req.UserEditRequestDTO;
import com.wjp.api.resp.UserResponseVO;
import com.wjp.common.Result;
import com.wjp.dao.entity.User;
import com.wjp.dao.system.UserDao;
import com.wjp.service.system.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * UserController
 *
 * @author wjp
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return Result
     */
    @Override
    public Result query(Long userId) {
        User user = userDao.getById(userId);
        if (Objects.isNull(user)) {
            throw new UserException("用户不存在");
        }
        UserResponseVO userResponseVO = new UserResponseVO();
        BeanUtils.copyProperties(user, userResponseVO);
        return Result.successResult(userResponseVO);
    }

    /**
     * 新增用户
     *
     * @param dto 用户信息
     * @return Result
     */
    @Override
    public Result addUser(UserAddRequestDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userDao.insertSelective(user);
        return Result.success();
    }

    /**
     * 编辑用户
     *
     * @param dto 用户信息
     * @return Result
     */
    @Override
    public Result editUser(UserEditRequestDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userDao.editUser(user);
        return Result.success();
    }
}
