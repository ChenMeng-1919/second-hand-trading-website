package com.jzh.xx.transaction.domain;

import javax.persistence.*;

public class Admin {
    /**
     * 管理员ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 管理员账号
     */
    @Column(name = "admin_name")
    private String adminName;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 获取管理员ID
     *
     * @return id - 管理员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员ID
     *
     * @param id 管理员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员账号
     *
     * @return admin_name - 管理员账号
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员账号
     *
     * @param adminName 管理员账号
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取管理员密码
     *
     * @return password - 管理员密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置管理员密码
     *
     * @param password 管理员密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}