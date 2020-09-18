package com.jzh.xx.transaction.service;

import com.alipay.api.domain.Shop;
import com.jzh.xx.transaction.domain.ShopOrder;
import com.jzh.xx.transaction.dto.ComResult;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.vo.OrderVO;

import java.util.List;

public interface OrderService {
    PageInfo<ShopOrder> page(int draw, int start, int length, ShopOrder order);

//    ComResult addOrder(ShopOrder order);
//
//    ComResult checkOrder(ShopOrder order);

    /**
     * 创建订单
     *
     * @param userId 会员 ID
     * @param  expressId  快递 ID
     * @return 订单 ID
     */
    Long create(Long userId, Long expressId);

    OrderVO getById(Long orderId);

    void updateOrder(ShopOrder order);

    Long getUserId(Long orderId);

    OrderVO getOrderId(Long userId);

    void updateStatus(Long id);

    void delete(Long id);

    void delSelected(String[] sIds);
}
