package com.study.shiro.shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import realm.CustomRealm;

/**
 * Shrio 加密的使用.
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_6 {

    @Test
    public void shiroEncryptionTest() {
        CustomRealm customRealm = new CustomRealm();


        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        //设置md5加密，并且设置验证匹配
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");//加密名称
        matcher.setHashIterations(1);//加密次数
        customRealm.setCredentialsMatcher(matcher);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("Bob","123456");

        subject.login(token);

        System.out.println("是否验证成功==>"+subject.isAuthenticated());
    }


}
