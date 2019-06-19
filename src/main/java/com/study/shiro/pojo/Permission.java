package com.study.shiro.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Table: permission
 */
@Data
public class Permission implements Serializable {
    /**
     * Table:     permission
     * Column:    id
     * Nullable:  false
     */
    private Integer id;

    /**
     * 权限id
     *
     * Table:     permission
     * Column:    permission_id
     * Nullable:  false
     */
    private String permissionId;

    /**
     * 权限名称
     *
     * Table:     permission
     * Column:    name
     * Nullable:  false
     */
    private String name;

    /**
     * 权限描述
     *
     * Table:     permission
     * Column:    description
     * Nullable:  true
     */
    private String description;

    /**
     * 权限访问路径
     *
     * Table:     permission
     * Column:    url
     * Nullable:  true
     */
    private String url;

    /**
     * 权限标识
     *
     * Table:     permission
     * Column:    perms
     * Nullable:  true
     */
    private String perms;

    /**
     * 父级权限id
     *
     * Table:     permission
     * Column:    parent_id
     * Nullable:  true
     */
    private Integer parentId;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     *
     * Table:     permission
     * Column:    type
     * Nullable:  true
     */
    private Integer type;

    /**
     * 排序
     *
     * Table:     permission
     * Column:    order_num
     * Nullable:  true
     */
    private Integer orderNum;

    /**
     * 图标
     *
     * Table:     permission
     * Column:    icon
     * Nullable:  true
     */
    private String icon;

    /**
     * 状态：1有效；2删除
     *
     * Table:     permission
     * Column:    status
     * Nullable:  false
     */
    private Integer status;

    /**
     * Table:     permission
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * Table:     permission
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}