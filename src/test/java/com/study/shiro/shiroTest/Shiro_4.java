package com.study.shiro.shiroTest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 * shiro jdbcRealm .
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class Shiro_4 {
    DruidDataSource druidDataSource = new DruidDataSource();

    {
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setUrl("jdbc:mysql://localhost/shirodemo?serverTimeZone=GMT%2B8");
    }

    @Test
    public void jdbcRealm() {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(druidDataSource);
        realm.setPermissionsLookupEnabled(true);//启动权限查询，默认为关闭
        /*
        默认SQL语句如下：
        //1.根据账户名查询密码
        protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
        //2.根据账户名查询密码和密码盐值
        protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";
        //3.根据账户名查询角色名
        protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";
        //4.根据角色名查询权限
        protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";
         */
        /*自定义SQL*/
//      String accountSql="select password from user where username=?";
//      realm.setAuthenticationQuery(SQL);  // 验证SQL(根据用户名查找密码）
//      String roleSql="select name from role where id=(select role_id from user_role where user_id=(select id from user where username=?))";
//      realm.setUserRolesQuery(SQL);       // 验证角色SQL（根据用户名查找角色)
//      String permissionSql="select name from permission where id=(select permission_id from role_permission where role_id =(select id from role where name=?))";
//      realm.setPermissionsQuery(SQL);    //验证权限SQL（根据角色名查找权限）
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Bob", "123456");
        subject.login(token);
        System.out.printf("是否验证成功==>" + subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermission("user:search");
    }
}
