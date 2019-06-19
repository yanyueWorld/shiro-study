package com.study.shiro.service;


import java.util.Set;

/**
 * CustomRealmService 自定义Realm业务逻辑层 .
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface CustomRealmService {

    /**
     * 通过用户名获得密码.
     *
     * @param username 用户名
     * @return String 密码
     */
    String getPasswordByUsername(String username);

    /**
     * 通过用户名获得角色.
     *
     * @param username 用户名
     * @return Set<String> 角色集合
     */
    Set<String> getRoleNameByUser(String username);

    /**
     * 通过用户名获得权限
     *
     * @param username 用户名
     * @return Set<String> 权限集合
     */
    Set<String> getPermissionsByUser(String username);

    /**
     * 通过用户名获取加密盐值
     *
     * @param username 用户名
     * @return String 盐值
     */
    String getSaltByUsername(String username);
}
