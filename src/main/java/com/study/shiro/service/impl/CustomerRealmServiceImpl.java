package com.study.shiro.service.impl;

import com.study.shiro.dao.UserDao;
import com.study.shiro.pojo.Permission;
import com.study.shiro.pojo.Role;
import com.study.shiro.pojo.User;
import com.study.shiro.service.CustomRealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * CustomerRealmServiceImpl 自定义Realm业务逻辑层实现类.
 *
 * @author yanyue, 2019/6/19
 * @version shiro v1.0
 */

@Service
public class CustomerRealmServiceImpl implements CustomRealmService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getPasswordByUsername(String username) {
        if(username==null||username.length()==0){
            return null;
        }
        User user=userDao.getUserByUsername(username);
        if(user==null){
            return null;
        }
        return user.getPassword();
    }

    @Override
    public Set<String> getRoleNameByUser(String username) {
        if(username==null||username.length()==0){
            return null;
        }
        User user=userDao.getUserByUsername(username);
        if(user==null){
            return null;
        }
        Set<String> roleNames=new HashSet<>();
        for(Role role:user.getRoles()){
            roleNames.add(role.getName());
        }
        return roleNames;
    }

    @Override
    public Set<String> getPermissionsByUser(String username) {
        if(username==null||username.length()==0){
            return null;
        }
        User user=userDao.getUserByUsername(username);
        if(user==null){
            return null;
        }
        Set<String> permissions=new HashSet<>();
        for(Role role:user.getRoles()){
            for(Permission permission:role.getPermissions()){
                permissions.add(permission.getPerms());
            }
        }
        return permissions;
    }

    @Override
    public String getSaltByUsername(String username){
        if(username==null||username.length()==0){
            return null;
        }
        User user=userDao.getUserByUsername(username);
        if(user==null){
            return null;
        }
        return user.getSalt();
    }
}
