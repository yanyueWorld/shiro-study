package com.study.shiro.dao;

import com.study.shiro.pojo.Permission;
import com.study.shiro.pojo.Role;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRolesByUserId(Integer userId);
}