package com.study.shiro.dao;

import com.study.shiro.pojo.Permission;

import java.util.List;
/**
 * PermissionDao 权限Dao层 .
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface PermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getPermissionsByRoleId(Integer roleId);
}