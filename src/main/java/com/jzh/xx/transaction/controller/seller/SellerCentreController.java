package com.jzh.xx.transaction.controller.seller;

import com.jzh.xx.transaction.domain.Seller;
import com.jzh.xx.transaction.service.GoodsService;
import com.jzh.xx.transaction.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("sellerCentre")
public class SellerCentreController {

    @Resource
    private SellerService sellerService;

    @Resource
    private GoodsService goodsService;

    @GetMapping("index")
    public String centre(Model model,HttpSession session){
        Seller seller = (Seller) session.getAttribute("seller");

        Map<String, Object> map = goodsService.IndexInfoBySellerId(seller.getId());

        String reputation = sellerService.getReputation(seller.getId());

        model.addAttribute("countBySellerId",map.get("countBySellerId"));
        model.addAttribute("soldCount",map.get("soldCount"));
        model.addAttribute("soldMoney",map.get("soldMoney"));
        model.addAttribute("reputation",reputation);
        return "seller/index";
    }


    @GetMapping("list")
    public String list(HttpSession session, Model model){
        Seller seller = (Seller) session.getAttribute("seller");

        model.addAttribute("seller",seller);
        return "seller/seller_info";
    }

    /**
     * 保存卖家信息
     * @param seller
     * @return
     */
    @PostMapping("save")
    public String save(Seller seller){
        sellerService.save(seller);
        return "seller/seller_info";
    }

    /**
     * 修改卖家信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping("update")
    public String toUpdate(HttpSession session, Model model){
        Seller seller = (Seller) session.getAttribute("seller");

        model.addAttribute("seller",seller);
        return "seller/info_update";
    }

}
