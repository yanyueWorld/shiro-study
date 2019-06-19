package com.study.shiro.dao;

import com.study.shiro.pojo.Permission;

import java.util.List;

/**
 * PermissionDao 权限Dao层.
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface PermissionDao {

    /**
     * 根据主键id删除数据.
     *
     * @param id 主键id
     * @return int 操作行数
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增权限.
     *
     * @param permission 权限对象
     * @return int 操作行数
     * @throws
     */
    int insertSelective(Permission permission);

    /**
     * 修改权限.
     *
     * @param permission 权限对象
     * @return int 操作行数
     * @throws
     */
    int updateByPrimaryKeySelective(Permission permission);

    /**
     * 根据角色id获取权限.
     *
     * @param roleId 角色id
     * @return List<Permission> 角色链表
     */
    List<Permission> getPermissionsByRoleId(Integer roleId);
}