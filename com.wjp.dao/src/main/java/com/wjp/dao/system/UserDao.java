package com.wjp.dao.system;


import com.wjp.dao.base.SuperDao;
import com.wjp.dao.entity.User;
import com.wjp.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 *
 * @author wjp
 */
@Repository
public class UserDao extends SuperDao<UserMapper, User> {
    /**
     * 插入用户
     *
     * @param user 用户信息
     */
    public void insertSelective(User user) {
        baseMapper.insertSelective(user);
    }

    /**
     * 编辑用户
     *
     * @param user 用户信息
     */
    public void editUser(User user) {
        baseMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> getUsers() {
        return baseMapper.getUsers();
    }
}
