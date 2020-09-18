package com.jzh.xx.transaction.domain;

import java.util.Date;
import javax.persistence.*;

public class Address {
    /**
     * 地址ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 联系人号码
     */
    @Column(name = "con_phone")
    private String conPhone;

    /**
     * 详细地址
     */
    @Column(name = "detail_addr")
    private String detailAddr;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 获取地址ID
     *
     * @return id - 地址ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置地址ID
     *
     * @param id 地址ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取联系人号码
     *
     * @return con_phone - 联系人号码
     */
    public String getConPhone() {
        return conPhone;
    }

    /**
     * 设置联系人号码
     *
     * @param conPhone 联系人号码
     */
    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    /**
     * 获取详细地址
     *
     * @return detail_addr - 详细地址
     */
    public String getDetailAddr() {
        return detailAddr;
    }

    /**
     * 设置详细地址
     *
     * @param detailAddr 详细地址
     */
    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    /**
     * 获取邮编
     *
     * @return postcode - 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
}