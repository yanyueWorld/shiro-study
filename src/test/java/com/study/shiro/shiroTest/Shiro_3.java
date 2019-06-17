package com.study.shiro.shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * shiro-3 iniRealm.
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_3 {

    @Test
    public void shiro_3() {
        IniRealm realm = new IniRealm("classpath:shiro.ini");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Bob", "123456");
        subject.login(token);

        System.out.printf("是否验证成功==>", subject.isAuthenticated());

        subject.checkPermission("user:search");
//        subject.checkPermissions("user:search","user:update");

//        subject.checkPermission("user:delete");//UnauthorizedException
    }

}
