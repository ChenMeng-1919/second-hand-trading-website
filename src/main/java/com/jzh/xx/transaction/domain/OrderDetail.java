package com.jzh.xx.transaction.domain;

import javax.persistence.*;

public class OrderDetail {
    /**
     * 订单详情ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单ID
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 卖家ID
     */
    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * 快递ID
     */
    @Column(name = "express_id")
    private Long expressId;

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
     * 商品图片
     */
    @Column(name = "goods_img")
    private String goodsImg;

    /**
     * 商品数量
     */
    @Column(name = "buy_count")
    private Integer buyCount;

    /**
     * 商品价格
     */
    @Column(name = "goods_price")
    private Double goodsPrice;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 获取订单详情ID
     *
     * @return id - 订单详情ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置订单详情ID
     *
     * @param id 订单详情ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单ID
     *
     * @return order_id - 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单ID
     *
     * @param orderId 订单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取卖家ID
     *
     * @return seller_id - 卖家ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖家ID
     *
     * @param sellerId 卖家ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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

    /**
     * 获取商品图片
     *
     * @return goods_img - 商品图片
     */
    public String getGoodsImg() {
        return goodsImg;
    }

    /**
     * 设置商品图片
     *
     * @param goodsImg 商品图片
     */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /**
     * 获取商品数量
     *
     * @return buy_count - 商品数量
     */
    public Integer getBuyCount() {
        return buyCount;
    }

    /**
     * 设置商品数量
     *
     * @param buyCount 商品数量
     */
    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    /**
     * 获取商品价格
     *
     * @return goods_price - 商品价格
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 设置商品价格
     *
     * @param goodsPrice 商品价格
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}