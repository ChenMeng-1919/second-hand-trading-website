package com.jzh.xx.transaction.controller;

import com.jzh.xx.transaction.domain.*;
import com.jzh.xx.transaction.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private SellerService sellerService;

    @Resource
    private CartService cartService;

    @Resource
    private CategoryTwoService categoryTwoService;

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detail/{id}")
    public String toDetail(@PathVariable Long id, Model model, HttpSession session){
        // 获取用户 ID
        XxUser user = (XxUser) session.getAttribute("user");

        // 购物车
        List<Cart> cartGoods = new ArrayList<>();
        if (user != null){
            cartGoods = cartService.getByUserId(user.getId());
        }
        Double total = 0.0;
        int goodsCount = cartGoods.size();
        if (cartGoods.size() >0){
            for (int i = 0; i< cartGoods.size(); i++){
                total += cartGoods.get(i).getBuyCount() * cartGoods.get(i).getGoodsPrice();
            }
        }
        // 父分类
        List<Category> categories = categoryService.categoryList();

        // 查询所有子分类
        List<CategoryTwo> categoryTwos = categoryTwoService.getAll();


        //商品详情
        Goods goods = goodsService.detail(id);
        Long categoryId = goods.getCategoryId();
        Long sellerId = goods.getSellerId();
        Category category = categoryService.showCategory(categoryId);
        Seller seller = sellerService.seller(sellerId);

        model.addAttribute("goodsId",id);
        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("goods",goods);
        model.addAttribute("category",category);
        model.addAttribute("seller",seller);
        return "shop_single";
    }
}
