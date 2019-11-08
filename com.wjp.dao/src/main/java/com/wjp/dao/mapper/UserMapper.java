package com.wjp.dao.mapper;


import com.wjp.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * UserMapper
 *
 * @author wjp
 * @date 2019/9/17
 */
@Mapper
public interface UserMapper extends SupperMapper<User> {

    int deleteByPrimaryKey(Long id);


    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUsers();

    void insertUsers(@Param("users") ArrayList<User> users);
}