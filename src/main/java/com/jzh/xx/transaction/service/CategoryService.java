package com.jzh.xx.transaction.service;

import com.jzh.xx.transaction.domain.Category;
import com.jzh.xx.transaction.dto.PageInfo;

import java.util.List;

public interface CategoryService {
    Category showCategory(Long id);

    PageInfo<Category> page(int draw, int start, int length, Category category);

    void save(Category category);

    Category getById(Long id);

    void deleteOne(int id);

    List<Category> categoryList();

    void deleteSelected(String[] sIds);
}