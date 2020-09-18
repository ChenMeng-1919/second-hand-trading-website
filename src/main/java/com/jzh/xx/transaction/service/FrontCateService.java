package com.jzh.xx.transaction.service;

import com.github.pagehelper.PageInfo;
import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.dto.PageResult;

public interface FrontCateService {
    PageResult<Goods> goodsPage(int pageNum, Long categoryId);
}
