package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.Goods;
import tk.mybatis.MyMapper;

import java.util.List;
import java.util.Map;

    public interface GoodsMapper extends MyMapper<Goods> {
    /**
     * 精选
     * @return
     */
    List<Goods> getChosen();

    /**
     * 白菜
     * @return
     */
    List<Goods> getCheaper();

    /**
     * 按分类查找
     * @return
     */
    List<Goods> getByCate(Long categoryId);

    /**
     * 分页
     * @param params
     * @return
     */
    List<Goods> goodsPage(Map<String,Object> params);

    /**
     * 商品已交易总额
     * @return
     */
    double getTotalSum();

    /**
     * 商品总数
     * @return
     */
    int getGoodsCount();

    /**
     * 一个卖家的商品数量
     * @param sellerId
     * @return
     */
    int GoodsCountBySellerId(Long sellerId);
}