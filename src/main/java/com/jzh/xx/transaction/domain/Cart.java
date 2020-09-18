package com.jzh.xx.transaction.domain;

import javax.persistence.*;

public class Cart {
    /**
     * 购物车ID
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
     * 卖家id
     */
    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 购买数量
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
     * 商品图片
     */
    @Column(name = "goods_img")
    private String goodsImg;

    /**
     * 获取购物车ID
     *
     * @return id - 购物车ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置购物车ID
     *
     * @param id 购物车ID
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
     * 获取卖家id
     *
     * @return seller_id - 卖家id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖家id
     *
     * @param sellerId 卖家id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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
     * 获取购买数量
     *
     * @return buy_count - 购买数量
     */
    public Integer getBuyCount() {
        return buyCount;
    }

    /**
     * 设置购买数量
     *
     * @param buyCount 购买数量
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
}