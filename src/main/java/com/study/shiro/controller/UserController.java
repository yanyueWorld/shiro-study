package com.study.shiro.controller;

import com.study.shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UserController 用户请求控制层
 *
 * @author yanyue, 2019/6/17
 * @version shiro v1.0
 */
@Controller
public class UserController {

    /**
     * 登录.
     *
     * @param user 用户对象
     * @return Sring 登录结果
     */
    @RequestMapping(value = "/subLogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String subLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            token.setRememberMe(user.getRememberMe());
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        //验证角色
        if (subject.hasRole("admin")) {
            return "admin";
        }
        return "登录成功";
    }

    /**
     * 角色控制
     *
     * @return String
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @ResponseBody
    public String testRole() {
        return "testRole";
    }

    /**
     * 权限控制
     *
     * @return String
     */
    @RequiresPermissions("account:*")
    @RequestMapping(value = "/testPermission", method = RequestMethod.GET)
    @ResponseBody
    public String testPermission() {
        return "testPermission";
    }

    /**
     * 权限控制
     */
    @RequestMapping(value = "/testPermission1", method = RequestMethod.GET)
    @ResponseBody
    public String testPermission1() {
        return "testPermission1";
    }

    /**
     * 权限控制
     */
    @RequestMapping(value = "/testPermission2", method = RequestMethod.GET)
    @ResponseBody
    public String testPermission2() {
        return "testPermission2";
    }

    /**
     * 角色控制
     */
    @RequestMapping(value = "/testRole1", method = RequestMethod.GET)
    @ResponseBody
    public String testRole1() {
        return "testRole1";
    }

    /**
     * 角色控制
     */
    @RequestMapping(value = "/testRole2", method = RequestMethod.GET)
    @ResponseBody
    public String testRole2() {
        return "testRole2";
    }

    /**
     * 自定义过滤器 角色控制
     */
    @RequestMapping(value = "/rolesOr", method = RequestMethod.GET)
    @ResponseBody
    public String rolesOr() {
        return "rolesOr";
    }
}
