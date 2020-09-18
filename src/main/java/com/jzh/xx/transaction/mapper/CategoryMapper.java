package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.Category;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends MyMapper<Category> {
    List<Category> categoryPage(Map<String,Object> params);
}