package com.study.shiro.shiroTest;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * shiro-helloWorld:shiro 账户验证.
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_1 {
    @Test
    public void shiroAuthenticator() {
        //创建Realm对象
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("Bob", "123456");

        //创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        //提交认证
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        //创建用户密码token
        UsernamePasswordToken token = new UsernamePasswordToken("Bob", "123456");

        //UsernamePasswordToken token=new UsernamePasswordToken("Json","123456"); //账户异常 UnknownAccountException
        //UsernamePasswordToken token=new UsernamePasswordToken("Bob","12345");   //密码异常 IncorrectCredentialsException
        //登录、退出
        subject.login(token);
        //subject.logout();

        System.out.println("验证是否成功==>" + subject.isAuthenticated());
    }
}
