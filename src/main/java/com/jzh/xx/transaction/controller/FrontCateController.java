package com.jzh.xx.transaction.controller;

import com.jzh.xx.transaction.domain.*;
import com.jzh.xx.transaction.dto.PageResult;
import com.jzh.xx.transaction.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("frontCategory")
public class FrontCateController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryTwoService categoryTwoService;

    @Resource
    private CartService cartService;

    @Resource
    private FrontCateService frontCateService;

    @GetMapping
    public String toCategory(){
        return "cate_list";
    }

    /**
     * 商品分类信息页
     * @param id
     * @param model
     * @param pageNum
     * @param session
     * @return
     */
    @GetMapping("list/{id}")
    public String categoryList(@PathVariable Long id, Model model, @RequestParam(defaultValue = "1") int pageNum, HttpSession session){
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

        //该父分类
        Category category = categoryService.getById(id);

        //子分类名称
        List<CategoryTwo> categoryTwos = categoryTwoService.getAll();

        //分类商品
        PageResult<Goods> goodsPageResult = frontCateService.goodsPage(pageNum,id);


        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("category",category);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("goodsList",goodsPageResult);
        return "cate_list";
    }

    /**
     * 主页小标题商品信息页
     * @param jb_status
     * @param model
     * @param session
     * @return
     */
    @GetMapping("subheading/{jb_status}")
    public String subheading(@PathVariable Long jb_status, Model model, HttpSession session){
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

        //小标题商品
        List<Goods> subGoods = null;
        int subStatus = 0;
        int subsize = 0;
        if (jb_status == 2){
            subStatus = 2;
            subGoods = goodsService.showCheaper();
            subsize = subGoods.size();
        }else if (jb_status == 1){
            subStatus = 1;
            subGoods = goodsService.showChosen();
            subsize = subGoods.size();
        }

        model.addAttribute("goodsCount",goodsCount);
        model.addAttribute("cartGoods",cartGoods);
        model.addAttribute("total",total);
        model.addAttribute("categories",categories);
        model.addAttribute("categoryTwos",categoryTwos);
        model.addAttribute("subGoods",subGoods);
        model.addAttribute("subStatus",subStatus);
        model.addAttribute("subsize",subsize);
        return "subheading";
    }
}
