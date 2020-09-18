package com.jzh.xx.transaction.domain;

import java.util.Date;
import javax.persistence.*;

public class Seller {
    /**
     * 卖家ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 卖家名
     */
    @Column(name = "seller_name")
    private String sellerName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 信誉程度
     */
    private String reputation;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 获取卖家ID
     *
     * @return id - 卖家ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置卖家ID
     *
     * @param id 卖家ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取卖家名
     *
     * @return seller_name - 卖家名
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * 设置卖家名
     *
     * @param sellerName 卖家名
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取信誉程度
     *
     * @return reputation - 信誉程度
     */
    public String getReputation() {
        return reputation;
    }

    /**
     * 设置信誉程度
     *
     * @param reputation 信誉程度
     */
    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}