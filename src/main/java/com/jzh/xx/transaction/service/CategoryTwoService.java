package com.jzh.xx.transaction.service;

import com.jzh.xx.transaction.domain.CategoryTwo;

import java.util.List;

public interface CategoryTwoService {
    /**
     * 查询所有子分类
     *
     * @return
     */
    List<CategoryTwo> getAll();
}
