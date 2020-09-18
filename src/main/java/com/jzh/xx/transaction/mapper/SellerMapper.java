package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.Seller;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

public interface SellerMapper extends MyMapper<Seller> {
    /**
     * 卖家分页
     * @param params
     * @return
     */
    List<Seller> sellerPage(Map<String,Object> params);

    /**
     * 卖家总数
     * @return
     */
    int getSellerCount();
}