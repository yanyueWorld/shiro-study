package com.study.shiro.dao;

import com.study.shiro.pojo.User;

/**
 * UserDao 用户Dao层.
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface UserDao {
    /**
     * 根据主键id删除数据.
     *
     * @param id 主键id
     * @return int 操作行数
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增用户.
     *
     * @param user 用户对象
     * @return int 操作行数
     * @throws
     */
    int insertSelective(User user);

    /**
     * 修改用户.
     *
     * @param user 用户对象
     * @return int 操作行数
     * @throws
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 根据用户名查询用户对象.
     *
     * @param username 用户名
     * @return User 用户对象
     */
    User getUserByUsername(String username);
}