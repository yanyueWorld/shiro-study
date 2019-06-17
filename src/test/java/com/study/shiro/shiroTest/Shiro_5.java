package com.study.shiro.shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import realm.CustomRealm;

/**
 * Shiro_5 customReal测试.
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_5 {
    @Test
    public void customerRealmTest(){
        CustomRealm customRealm=new CustomRealm();

        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("Bob","123456");
        subject.login(token);

        System.out.println("验证是否成功==>"+subject.isAuthenticated());
        subject.checkPermission("user:search");
        subject.checkRoles("admin","user");
    }
}
