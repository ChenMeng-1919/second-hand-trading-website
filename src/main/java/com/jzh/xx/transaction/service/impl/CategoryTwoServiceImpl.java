package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.CategoryTwo;
import com.jzh.xx.transaction.mapper.CategoryTwoMapper;
import com.jzh.xx.transaction.service.CategoryTwoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryTwoServiceImpl implements CategoryTwoService {
    @Resource
    private CategoryTwoMapper categoryTwoMapper;

    @Override
    public List<CategoryTwo> getAll() {
        return categoryTwoMapper.selectAll();
    }
}
