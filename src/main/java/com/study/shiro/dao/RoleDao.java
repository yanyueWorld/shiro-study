package com.study.shiro.dao;

import com.study.shiro.pojo.Role;

import java.util.List;

/**
 * RoleDao 角色Dao层 .
 *
 * @author yanyue, 2019/6/19
 * @version Araf v1.0
 */
public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRolesByUserId(Integer userId);
}