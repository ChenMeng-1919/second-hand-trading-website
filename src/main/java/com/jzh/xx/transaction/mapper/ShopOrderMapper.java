package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.ShopOrder;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface ShopOrderMapper extends MyMapper<ShopOrder> {
    List<ShopOrder> orderPage(Map<String,Object> params);
}