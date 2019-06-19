package com.study.shiro.realm;

import com.study.shiro.dao.UserDao;
import com.study.shiro.pojo.Permission;
import com.study.shiro.pojo.Role;
import com.study.shiro.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 自定义Realm
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
public class CustomRealm extends AuthorizingRealm {
    /*Map<String,String> userMap=new HashMap<>();
    {
        userMap.put("bob","84de1a43e7d1c2f246eb79310c306057");
    }*/
    @Autowired
    private UserDao userDao;

    //  获取Md5加密之后的值
    public static void main(String[] args) {
        String password = "admin";
        String model = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuffer salt = new StringBuffer();
        for (int j = 0; j < 6; j++) {
            salt.append(model.charAt(random.nextInt(35)) + "");
        }
        System.out.println(salt);
        //加上盐值之后
        Md5Hash md5Hash1 = new Md5Hash(password, salt.toString());
        System.out.println("md5WithSalt==>" + md5Hash1);
    }

    /**
     * 授权.
     *
     * @param principals 身份集合
     * @return AuthorizationInfo 授权信息对象
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("principals==>" + principals);
        //从凭证中获取用户名
        String username = (String) principals.getPrimaryPrincipal();

        //获取角色，权限信息
        Set<String> roles = getRoleByUsername(username);
        Set<String> permissions = getPermissionsByUsername(username);

        //返回授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        info.setRoles(roles);
        System.out.println("info==>" + info);
        return info;
    }

    /**
     * 模拟从数据库中或者缓存中获取角色集合
     *
     * @param username 账户名
     * @return Set 角色集合
     */
   /*private Set<String> getRoleByUsername(String username) {
        Set<String> set=new HashSet<>();
        set.add("admin");
        set.add("user");
        return set;
    }*/
    private Set<String> getRoleByUsername(String username) {
        Set<String> set = new HashSet<>();
        List<Role> roles = userDao.getUserByUsername(username).getRoles();
        for (Role role : roles) {
            set.add(role.getName());
        }
        System.out.println("role==>"+set);
        return set;
    }

    /**
     * 模拟从数据库中或者缓存中获取权限集合
     *
     * @param username 账户名
     * @return Set 权限集合
     */
    /*private Set<String> getPermissionsByUsername(String username) {
        Set<String> set=new HashSet<>();
        set.add("user:search");
        set.add("user:update");
        return set;
    }*/
    private Set<String> getPermissionsByUsername(String username) {
        Set<String> set = new HashSet<>();
        List<Role> roles = userDao.getUserByUsername(username).getRoles();
        for (Role role : roles) {
            for (Permission permission : role.getPermissions()) {
                set.add(permission.getName());
            }
        }
        System.out.println("permission==>"+set);
        return set;
    }

    /**
     * 验证.
     *
     * @param token 验证的token
     * @return AuthenticationInfo 验证信息对象
     * @throws AuthenticationException 权限认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从凭据中获取用户名
        String username = (String) token.getPrincipal();
        System.out.println("username==>" + username);
        //通过用户名获取密码
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }

        //比对账户信息，是则返回认证信息，否则抛出异常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
        String salt=getSaltByUsername(username);
        info.setCredentialsSalt(ByteSource.Util.bytes(salt));
        return info;
    }

    /**
     * 模拟从数据库获取凭证
     *
     * @param username 账户名
     * @return String 密码字符串
     */
    /*private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }*/
    private String getPasswordByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        System.out.println(user.getPassword());
        if (user != null) {
            return user.getPassword();
        }
        return null;
    }

    private String getSaltByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        if(user!=null){
            System.out.println(user.getSalt());
            return user.getSalt();
        }
        return null;
    }
}
