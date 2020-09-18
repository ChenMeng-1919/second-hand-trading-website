package com.jzh.xx.transaction.mapper;

import com.jzh.xx.transaction.domain.OrderDetail;
import tk.mybatis.MyMapper;

import java.util.List;

public interface OrderDetailMapper extends MyMapper<OrderDetail> {


    /**
     *获取订单项
     * @param orderId
     * @return
     */
    List<OrderDetail> getByOrderId(Long orderId);
}