package com.jzh.xx.transaction.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
public class Goods {
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 卖家ID
     */
    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 价格
     */
    private Double price;

    /**
     * 原价格
     */
    @Column(name = "original_price")
    private Double originalPrice;

    /**
     * 描述
     */
    @Column(name = "goods_detail")
    private String goodsDetail;

    /**
     * 数量
     */
    @Column(name = "goods_number")
    private Integer goodsNumber;

    /**
     * 热度
     */
    private Integer heat;

    /**
     * 图片1
     */
    private String picture1;

    /**
     * 图片2
     */
    private String picture2;

    /**
     * 图片3
     */
    private String picture3;

    /**
     * 图片4
     */
    private String picture4;

    /**
     * 图片5
     */
    private String picture5;

    /**
     * 精选1 白菜2
     */
    @Column(name = "jb_status")
    private Byte jbStatus;

    /**
     * 售出0 还有1
     */
    @Column(name = "sell_status")
    private Byte sellStatus;

    /**
     * 上架时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 分类
     */
    private Category category;

    /**
     * 获取商品ID
     *
     * @return id - 商品ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品ID
     *
     * @param id 商品ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取原价格
     *
     * @return original_price - 原价格
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价格
     *
     * @param originalPrice 原价格
     */
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取描述
     *
     * @return goods_detail - 描述
     */
    public String getGoodsDetail() {
        return goodsDetail;
    }

    /**
     * 设置描述
     *
     * @param goodsDetail 描述
     */
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    /**
     * 获取数量
     *
     * @return goods_number - 数量
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * 设置数量
     *
     * @param goodsNumber 数量
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * 获取热度
     *
     * @return heat - 热度
     */
    public Integer getHeat() {
        return heat;
    }

    /**
     * 设置热度
     *
     * @param heat 热度
     */
    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    /**
     * 获取图片1
     *
     * @return picture1 - 图片1
     */
    public String getPicture1() {
        return picture1;
    }

    /**
     * 设置图片1
     *
     * @param picture1 图片1
     */
    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    /**
     * 获取图片2
     *
     * @return picture2 - 图片2
     */
    public String getPicture2() {
        return picture2;
    }

    /**
     * 设置图片2
     *
     * @param picture2 图片2
     */
    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    /**
     * 获取图片3
     *
     * @return picture3 - 图片3
     */
    public String getPicture3() {
        return picture3;
    }

    /**
     * 设置图片3
     *
     * @param picture3 图片3
     */
    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    /**
     * 获取图片4
     *
     * @return picture4 - 图片4
     */
    public String getPicture4() {
        return picture4;
    }

    /**
     * 设置图片4
     *
     * @param picture4 图片4
     */
    public void setPicture4(String picture4) {
        this.picture4 = picture4;
    }

    /**
     * 获取图片5
     *
     * @return picture5 - 图片5
     */
    public String getPicture5() {
        return picture5;
    }

    /**
     * 设置图片5
     *
     * @param picture5 图片5
     */
    public void setPicture5(String picture5) {
        this.picture5 = picture5;
    }

    /**
     * 获取精选1 白菜2
     *
     * @return jb_status - 精选1 白菜2
     */
    public Byte getJbStatus() {
        return jbStatus;
    }

    /**
     * 设置精选1 白菜2
     *
     * @param jbStatus 精选1 白菜2
     */
    public void setJbStatus(Byte jbStatus) {
        this.jbStatus = jbStatus;
    }

    /**
     * 获取售出0 还有1
     *
     * @return sell_status - 售出0 还有1
     */
    public Byte getSellStatus() {
        return sellStatus;
    }

    /**
     * 设置售出0 还有1
     *
     * @param sellStatus 售出0 还有1
     */
    public void setSellStatus(Byte sellStatus) {
        this.sellStatus = sellStatus;
    }

    /**
     * 获取上架时间
     *
     * @return created - 上架时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置上架时间
     *
     * @param created 上架时间
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