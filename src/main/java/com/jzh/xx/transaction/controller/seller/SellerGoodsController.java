package com.jzh.xx.transaction.controller.seller;


import com.jzh.xx.transaction.domain.Goods;
import com.jzh.xx.transaction.domain.Seller;
import com.jzh.xx.transaction.dto.PageInfo;
import com.jzh.xx.transaction.service.CategoryService;
import com.jzh.xx.transaction.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("sellerGoods")
public class SellerGoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 遍历商品信息
     * @param request
     * @param goods
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public PageInfo<Goods> pageInfo(HttpServletRequest request, Goods goods){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        int draw = strdraw == null ? 0: Integer.parseInt(strdraw);
        int start = strstart == null ? 0: Integer.parseInt(strstart);
        int length = strlength == null ? 10: Integer.parseInt(strlength);

        PageInfo<Goods> pageInfo = goodsService.page(draw,start,length,goods);
        return pageInfo;
    }

    @GetMapping("list")
    public String toSellerGoods(HttpSession session){
        return "seller/seller_goods";
    }

    /**
     * 保存商品信息
     * @param goods
     * @param session
     * @return
     */
    @Transactional
    @PostMapping("save")
    public String addGoods(Goods goods, HttpSession session){
        Seller seller = (Seller) session.getAttribute("seller");
        goods.setSellerId(seller.getId());
        goodsService.save(goods);
        return "seller/seller_goods";
    }

    /**
     * 在修改商品信息时将商品原本信息传入
     * @param model
     * @param session
     * @return
     */
    @GetMapping("add")
    public String toAdd(Model model,HttpSession session){
        Seller seller = (Seller) session.getAttribute("seller");
        model.addAttribute("seller",seller);
        return "seller/goods_from";
    }

    /**
     * 更新商品
     * @param id
     * @param model
     * @return
     */
    @GetMapping("update")
    public String update(Long id, Model model){
        Goods goods = goodsService.detail(id);
        model.addAttribute("goods",goods);
        return "seller/goods_update";
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String delete(Long id){
        goodsService.delete(id);
        return "seller/seller_goods";
    }

    @GetMapping("delSelected")
    public String delSelected(String ids){
        String sIds[] = ids.split(",");
        goodsService.delSelected(sIds);
        return "seller/seller_goods";
    }
}
