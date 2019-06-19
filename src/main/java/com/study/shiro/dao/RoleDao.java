package com.study.shiro.dao;

import com.study.shiro.pojo.Role;

import java.util.List;

/**
 * RoleDao 角色Dao层.
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface RoleDao {
    /**
     * 根据主键id删除数据.
     *
     * @param id 主键id
     * @return int 操作行数
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增角色.
     *
     * @param role 角色对象
     * @return int 操作行数
     * @throws
     */
    int insertSelective(Role role);

    /**
     * 修改角色.
     *
     * @param role 角色对象
     * @return int 操作行数
     * @throws
     */
    int updateByPrimaryKeySelective(Role role);

    /**
     * 根据用户id查询角色.
     *
     * @param userId 用户id
     * @return List<Role> 角色链表
     * @throws
     */
    List<Role> getRolesByUserId(Integer userId);
}