package com.study.shiro.dao;

import com.study.shiro.pojo.User;

/**
 * UserDao 用户Dao层 .
 *
 * @author yanyue, 2019/6/19
 * @version Araf v1.0
 */
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByUsername(String username);
}