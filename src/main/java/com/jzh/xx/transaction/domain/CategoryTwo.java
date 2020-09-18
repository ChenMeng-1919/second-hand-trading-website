package com.jzh.xx.transaction.domain;

import javax.persistence.*;

public class CategoryTwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "two_name")
    private String twoName;

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
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return two_name
     */
    public String getTwoName() {
        return twoName;
    }

    /**
     * @param twoName
     */
    public void setTwoName(String twoName) {
        this.twoName = twoName;
    }
}