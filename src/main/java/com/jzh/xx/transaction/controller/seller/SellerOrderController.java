package com.jzh.xx.transaction.controller.seller;

import com.jzh.xx.transaction.domain.ShopOrder;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sellerOrder")
public class SellerOrderController {

    @Resource
    private OrderService orderService;

    /**
     *订单分页
     * @param request
     * @param shopOrder
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<ShopOrder> pageInfo(HttpServletRequest request, ShopOrder shopOrder){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<ShopOrder> pageInfo = orderService.page(draw,start,length,shopOrder);
        return pageInfo;
    }

    @GetMapping("list")
    public String toSellerOrders(HttpSession session){
        return "seller/seller_order";
    }

    /**
     * 设为发货
     * @param id
     * @return
     */
    @GetMapping("deliver")
    public String deliver(Long id){
        orderService.updateStatus(id);
        return "seller/seller_order";
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String delete(Long id){
        orderService.delete(id);
        return "seller/seller_order";
    }

    /**
     * 删除选中
     * @param ids
     * @return
     */
    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        orderService.delSelected(sIds);
        return "seller/seller_order";
    }
}
