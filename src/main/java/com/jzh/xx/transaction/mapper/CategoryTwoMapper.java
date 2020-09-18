package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.CategoryTwo;
import tk.mybatis.MyMapper;

import java.util.List;

public interface CategoryTwoMapper extends MyMapper<CategoryTwo> {
    List<CategoryTwo> getByCategoryId(Long categoryId);
}