package com.jzh.xx.transaction.domain;

import javax.persistence.*;

public class Express {
    /**
     * 快递ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 快递名称
     */
    @Column(name = "express_name")
    private String expressName;

    /**
     * 快递价格
     */
    @Column(name = "express_price")
    private Double expressPrice;

    /**
     * 获取快递ID
     *
     * @return id - 快递ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置快递ID
     *
     * @param id 快递ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取快递名称
     *
     * @return express_name - 快递名称
     */
    public String getExpressName() {
        return expressName;
    }

    /**
     * 设置快递名称
     *
     * @param expressName 快递名称
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * 获取快递价格
     *
     * @return express_price - 快递价格
     */
    public Double getExpressPrice() {
        return expressPrice;
    }

    /**
     * 设置快递价格
     *
     * @param expressPrice 快递价格
     */
    public void setExpressPrice(Double expressPrice) {
        this.expressPrice = expressPrice;
    }
}