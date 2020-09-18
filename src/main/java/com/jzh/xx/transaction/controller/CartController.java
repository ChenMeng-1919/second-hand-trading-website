package com.jzh.xx.transaction.controller;

import com.jzh.xx.transaction.domain.*;
import com.jzh.xx.transaction.service.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController {

    @Resource
    private CartService cartService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryTwoService categoryTwoService;

    @Resource
    private ExpressService expressService;

    /**
     * 添加一件商品
     * @param sellerId
     * @param goodsId
     * @param session
     * @return
     */
    @PostMapping("goods/add")
    @ResponseBody
    public Map<String, Object> add(Long sellerId, Long goodsId,HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        // 获取用户 ID
        XxUser user = (XxUser) session.getAttribute("user");
        if (user != null){
            int exit = 1;
            // 添加商品到购物车
            List<Cart> cartGoods = cartService.add(user.getId(), sellerId,goodsId );
            // 计算购物车总金额
            Double total = 0.0;
            for (int i = 0; i < cartGoods.size(); i++) {
                total += cartGoods.get(i).getBuyCount() * cartGoods.get(i).getGoodsPrice();
            }

            result.put("cartGoods", cartGoods);
            result.put("total", total);
            result.put("exit",exit);

            return result;
        } else {
            int exit = 2;
            result.put("exit",exit);
            return result;
        }
    }

    /**
     * 删除商品
     * @param goodsId
     * @param session
     * @return
     */
    @PostMapping("goods/delete")
    @ResponseBody
    public Map<String, Object> delete(Long goodsId , HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        // 获取用户 ID
        XxUser user = (XxUser) session.getAttribute("user");

        // 添加商品到购物车
        List<Cart> cartGoods = cartService.delete(user.getId(),goodsId);
        // 计算购物车总金额
        Double total = 0.0;
        for (int i = 0; i < cartGoods.size(); i++) {
            total += cartGoods.get(i).getBuyCount() * cartGoods.get(i).getGoodsPrice();
        }

        result.put("cartGoods", cartGoods);
        result.put("total", total);

        return result;
    }

    /**
     * 遍历购物车清单
     * @param model
     * @param session
     * @return
     */
    @GetMapping("detail/{id}")
    public String toCart(@PathVariable Long id, Model model, HttpSession session){
        // 获取用户 ID
        XxUser user = (XxUser) session.getAttribute("user");

        // 购物车
        List<Cart> cartGoods = new ArrayList<>();
        if (user != null){
            cartGoods = cartService.getByUserId(id);
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

        //查询所有快递
        List<Express> expresses = expressService.getAll();


        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("expresses",expresses);
        return "frontCart";
    }


}
