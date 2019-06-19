package com.study.shiro.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Table: role
 */
@Data
public class Role implements Serializable {
    /**
     * Table:     role
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * 角色id
     *
     * Table:     role
     * Column:    role_id
     * Nullable:  false
     */
    private String roleId;

    /**
     * 角色名称
     *
     * Table:     role
     * Column:    name
     * Nullable:  false
     */
    private String name;

    /**
     * 角色描述
     *
     * Table:     role
     * Column:    description
     * Nullable:  true
     */
    private String description;

    /**
     * 状态：1有效；2删除
     *
     * Table:     role
     * Column:    status
     * Nullable:  false
     */
    private Integer status;

    /**
     * 创建时间
     *
     * Table:     role
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * Table:     role
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    private List<Permission> permissions;

    private static final long serialVersionUID = 1L;
}