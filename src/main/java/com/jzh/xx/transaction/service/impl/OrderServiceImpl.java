package com.jzh.xx.transaction.service.impl;

import com.jzh.xx.transaction.domain.*;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.mapper.*;
import com.jzh.xx.transaction.service.OrderService;
import com.jzh.xx.transaction.utils.IDUtil;
import com.jzh.xx.transaction.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ShopOrderMapper shopOrderMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private ExpressMapper expressMapper;


    /**
     * 后台订单信息
     * @param draw
     * @param start
     * @param length
     * @param order
     * @return
     */
    @Override
    public PageInfo<ShopOrder> page(int draw, int start, int length, ShopOrder order) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("order", order);

        int count = shopOrderMapper.selectCount(order);
        PageInfo<ShopOrder> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(shopOrderMapper.orderPage(params));

        return pageInfo;
    }

    /**
     * 添加订单
     * @param userId 会员 ID
     * @param  expressId  快递 ID
     * @return
     */
    @Transactional
    @Override
    public Long create(Long userId, Long expressId) {
        // 获取会员在该店铺的购物车
        List<Cart> carts = cartMapper.getByUserId(userId);

        //获取快递
        Express express = expressMapper.selectByPrimaryKey(expressId);

        // 生成订单 ID
        Long orderId = IDUtil.getRandomId();

        // 遍历购物车生成订单项，订单总金额
        List<OrderDetail> orderDetails = new ArrayList<>();
        Double orderPrice = 0.0;
        for (int i = 0; i < carts.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            Cart cart = carts.get(i);
            // 将购物车项转换为订单项
            BeanUtils.copyProperties(cart, orderDetail, "id");
            orderDetail.setId(IDUtil.getRandomId());
            orderDetail.setOrderId(orderId);
            orderDetail.setExpressId(expressId);
            orderDetail.setExpressName(express.getExpressName());
            orderDetail.setExpressPrice(express.getExpressPrice());
            // 添加订单项到数据库
            orderDetailMapper.insert(orderDetail);
            orderDetails.add(orderDetail);
            orderPrice += cart.getGoodsPrice() * (cart.getBuyCount() * 1.0);
        }

        //计算总额
        orderPrice += express.getExpressPrice();

        // 创建订单
        ShopOrder order = new ShopOrder();
        order.setId(orderId);
        order.setUserId(userId);
        order.setExpressId(expressId);
        order.setOrderPrice(orderPrice);
        order.setStatus((byte) 2);
        order.setCreated(new Date());
        shopOrderMapper.insert(order);
        return orderId;
    }

    @Override
    public OrderVO getById(Long orderId) {
        OrderVO orderVO = new OrderVO();

        // 根据订单 ID 查询出订单信息
        ShopOrder order = shopOrderMapper.selectByPrimaryKey(orderId);

        //订单id
        orderVO.setId(orderId);

        // 订单快递信息
        Long expressId = order.getExpressId();
        Express express = expressMapper.selectByPrimaryKey(expressId);
        orderVO.setExpress(express);

        // 订单项信息
        List<OrderDetail> orderDetails = orderDetailMapper.getByOrderId(orderId);
        orderVO.setOrderDetails(orderDetails);

        // 订单总金额
        Double orderPrice = order.getOrderPrice();
        orderVO.setTotal(orderPrice);

        //订单创建时间
        Date orderDate = order.getCreated();
        orderVO.setCreateTime(orderDate);
        return orderVO;
    }

    @Override
    public void updateOrder(ShopOrder order) {
        Example example = new Example(ShopOrder.class);
        example.createCriteria().andEqualTo("id",order.getId());
        shopOrderMapper.updateByExampleSelective(order,example);
    }

    @Override
    public Long getUserId(Long orderId) {
        ShopOrder order = shopOrderMapper.selectByPrimaryKey(orderId);
        Long userId = order.getUserId();
        return userId;
    }

    @Override
    public OrderVO getOrderId(Long userId) {
        OrderVO orderVO = new OrderVO();
        Example example = new Example(ShopOrder.class);
        example.createCriteria().andEqualTo("userId",userId);
        List<ShopOrder> shopOrders = shopOrderMapper.selectByExample(example);
        for (int i = 0;i < shopOrders.size();i++){
            Long orderId = shopOrders.get(i).getId();
            //订单创建时间
            Date orderDate = shopOrders.get(i).getCreated();
            orderVO.setCreateTime(orderDate);
            //根据订单 ID 查询出订单信息
            List<OrderDetail> orderDetails = orderDetailMapper.getByOrderId(orderId);
            orderVO.setOrderDetails(orderDetails);
        }
        return orderVO;
    }

    @Override
    public void updateStatus(Long id) {
        ShopOrder shopOrder = shopOrderMapper.selectByPrimaryKey(id);
        shopOrder.setStatus((byte) 1);
        shopOrderMapper.updateByPrimaryKeySelective(shopOrder);
    }

    @Override
    public void delete(Long id) {
        Example example = new Example(OrderDetail.class);
        example.createCriteria().andEqualTo("orderId",id);
        orderDetailMapper.deleteByExample(example);

        shopOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delSelected(String[] sIds) {
        for (String sId : sIds) {
            int id = Integer.parseInt(sId);
            delete(Long.valueOf(id));
        }
    }
}
