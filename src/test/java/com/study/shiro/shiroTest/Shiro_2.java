package com.study.shiro.shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * shiro-2 账户授权.
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_2 {
    @Before
    public void getSecurityManager() {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("Bob", "123456", "user");
//        realm.addAccount("Bob","123456","user","admin");
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Test
    public void shiroAuthorizer() {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Bob", "123456", "user");
        subject.login(token);
        System.out.println("验证是否成功==>" + subject.isAuthenticated());

        subject.checkRole("user");

//        subject.checkRole("users");  //UnauthorizedException
//        subject.checkRoles("user","admin");
    }
}
