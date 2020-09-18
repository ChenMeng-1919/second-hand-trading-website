package com.jzh.xx.transaction.domain;

import java.util.Date;
import javax.persistence.*;

public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 卖家ID
     */
    @Column(name = "seller_id")
    private Long sellerId;

    /**
     * 名称
     */
    @Column(name = "banner_name")
    private String bannerName;

    /**
     * 价格
     */
    @Column(name = "banner_price")
    private Double bannerPrice;

    /**
     * 详情
     */
    @Column(name = "banner_detail")
    private String bannerDetail;

    /**
     * 库存
     */
    @Column(name = "banner_number")
    private Integer bannerNumber;

    private String img1;

    private String img2;

    private String img3;

    /**
     * 是否卖出
     */
    @Column(name = "sell_status")
    private Byte sellStatus;

    private Date created;

    private Date updated;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
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
     * 获取名称
     *
     * @return banner_name - 名称
     */
    public String getBannerName() {
        return bannerName;
    }

    /**
     * 设置名称
     *
     * @param bannerName 名称
     */
    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    /**
     * 获取价格
     *
     * @return banner_price - 价格
     */
    public Double getBannerPrice() {
        return bannerPrice;
    }

    /**
     * 设置价格
     *
     * @param bannerPrice 价格
     */
    public void setBannerPrice(Double bannerPrice) {
        this.bannerPrice = bannerPrice;
    }

    /**
     * 获取详情
     *
     * @return banner_detail - 详情
     */
    public String getBannerDetail() {
        return bannerDetail;
    }

    /**
     * 设置详情
     *
     * @param bannerDetail 详情
     */
    public void setBannerDetail(String bannerDetail) {
        this.bannerDetail = bannerDetail;
    }

    /**
     * 获取库存
     *
     * @return banner_number - 库存
     */
    public Integer getBannerNumber() {
        return bannerNumber;
    }

    /**
     * 设置库存
     *
     * @param bannerNumber 库存
     */
    public void setBannerNumber(Integer bannerNumber) {
        this.bannerNumber = bannerNumber;
    }

    /**
     * @return img1
     */
    public String getImg1() {
        return img1;
    }

    /**
     * @param img1
     */
    public void setImg1(String img1) {
        this.img1 = img1;
    }

    /**
     * @return img2
     */
    public String getImg2() {
        return img2;
    }

    /**
     * @param img2
     */
    public void setImg2(String img2) {
        this.img2 = img2;
    }

    /**
     * @return img3
     */
    public String getImg3() {
        return img3;
    }

    /**
     * @param img3
     */
    public void setImg3(String img3) {
        this.img3 = img3;
    }

    /**
     * 获取是否卖出
     *
     * @return sell_status - 是否卖出
     */
    public Byte getSellStatus() {
        return sellStatus;
    }

    /**
     * 设置是否卖出
     *
     * @param sellStatus 是否卖出
     */
    public void setSellStatus(Byte sellStatus) {
        this.sellStatus = sellStatus;
    }

    /**
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}