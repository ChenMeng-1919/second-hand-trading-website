package com.jzh.xx.transaction.controller.seller;

import com.jzh.xx.transaction.domain.Seller;
import com.jzh.xx.transaction.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sellerLogin")
public class SellerLoginController {

    @Resource
    private SellerService sellerService;

    @GetMapping("login")
    public String login(){
        return "seller/login";
    }

    /**
     * 卖家登录
     * @param phone
     * @param password
     * @param model
     * @return
     */
    @PostMapping("login")
    public String loginByPassword(String phone, String password, Model model, HttpSession session){
        Seller seller = sellerService.login(phone, password);

        if (seller != null){
            session.setAttribute("seller",seller);
            return "redirect:/sellerCentre/index";
        }
        else {
            model.addAttribute("message","用户名或密码错误");
            return "seller/login";
        }
    }

    /**
     * 卖家注册
     * @return
     */
    @GetMapping("register")
    public String toRegister(){
        return "seller/register";
    }

    /**
     * 注册
     * @param realname
     * @param phone
     * @param city
     * @param password
     * @param repassword
     * @return
     */
    @PostMapping("register")
    public String register(String realname, String phone, String city, String password, String repassword){
        if(!password.equals(repassword)){
            return "redirect:/sellerLogin/register";
        }
        sellerService.register(realname, phone, city, password);
        return "redirect:/sellerLogin/login";
    }

}
