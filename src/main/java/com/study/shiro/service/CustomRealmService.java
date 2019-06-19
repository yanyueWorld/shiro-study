package com.study.shiro.service;

import com.study.shiro.pojo.Role;


import java.util.Set;

/**
 * CustomRealmService 自定义Realm业务逻辑层 .
 *
 * @author yanyue, 2019/6/19
 * @version Shiro v1.0
 */
public interface CustomRealmService {
    String getPasswordByUsername(String username);
    Set<String> getRoleNameByUser(String username);
    Set<String> getPermissionsByUser(String username);
    String getSaltByUsername(String username);
}
