package com.jzh.xx.transaction.domain;

import java.util.Date;
import javax.persistence.*;

public class ShopOrder {
    /**
     * 订单ID
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
     * 快递ID
     */
    @Column(name = "express_id")
    private Long expressId;

    /**
     * 订单价格
     */
    @Column(name = "order_price")
    private Double orderPrice;

    /**
     * 订单备注
     */
    @Column(name = "order_remarks")
    private String orderRemarks;

    /**
     * 1完成  2未完成
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 完成时间
     */
    @Column(name = "over_time")
    private Date overTime;

    /**
     * 获取订单ID
     *
     * @return id - 订单ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置订单ID
     *
     * @param id 订单ID
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
     * 获取快递ID
     *
     * @return express_id - 快递ID
     */
    public Long getExpressId() {
        return expressId;
    }

    /**
     * 设置快递ID
     *
     * @param expressId 快递ID
     */
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    /**
     * 获取订单价格
     *
     * @return order_price - 订单价格
     */
    public Double getOrderPrice() {
        return orderPrice;
    }

    /**
     * 设置订单价格
     *
     * @param orderPrice 订单价格
     */
    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 获取订单备注
     *
     * @return order_remarks - 订单备注
     */
    public String getOrderRemarks() {
        return orderRemarks;
    }

    /**
     * 设置订单备注
     *
     * @param orderRemarks 订单备注
     */
    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    /**
     * 获取1完成  2未完成
     *
     * @return status - 1完成  2未完成
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1完成  2未完成
     *
     * @param status 1完成  2未完成
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * 获取完成时间
     *
     * @return over_time - 完成时间
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * 设置完成时间
     *
     * @param overTime 完成时间
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }
}