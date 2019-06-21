package com.study.shiro.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Table: user
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Table:     user
     * Column:    id
     * Nullable:  false
     */
    private Integer id;
    /**
     * 用户id
     * <p>
     * Table:     user
     * Column:    user_id
     * Nullable:  false
     */
    private String userId;
    /**
     * 用户名
     * <p>
     * Table:     user
     * Column:    username
     * Nullable:  false
     */
    private String username;
    /**
     * Table:     user
     * Column:    password
     * Nullable:  false
     */
    private String password;
    /**
     * 加密盐值
     * <p>
     * Table:     user
     * Column:    salt
     * Nullable:  true
     */
    private String salt;
    /**
     * 邮箱
     * <p>
     * Table:     user
     * Column:    email
     * Nullable:  true
     */
    private String email;
    /**
     * 联系方式
     * <p>
     * Table:     user
     * Column:    phone
     * Nullable:  true
     */
    private String phone;
    /**
     * 年龄：1男2女
     * <p>
     * Table:     user
     * Column:    sex
     * Nullable:  true
     */
    private Integer sex;
    /**
     * 年龄
     * <p>
     * Table:     user
     * Column:    age
     * Nullable:  true
     */
    private Integer age;
    /**
     * 用户状态：1有效; 2删除
     * <p>
     * Table:     user
     * Column:    status
     * Nullable:  false
     */
    private Integer status;
    /**
     * 创建时间
     * <p>
     * Table:     user
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;
    /**
     * 更新时间
     * <p>
     * Table:     user
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;
    /**
     * 最后登录时间
     * <p>
     * Table:     user
     * Column:    last_login_time
     * Nullable:  true
     */
    private Date lastLoginTime;
    private List<Role> roles;
    private Boolean rememberMe;
}