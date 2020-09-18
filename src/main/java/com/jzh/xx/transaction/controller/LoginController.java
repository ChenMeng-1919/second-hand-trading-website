package com.jzh.xx.transaction.controller;

import com.jzh.xx.transaction.domain.XxUser;
import com.jzh.xx.transaction.service.UserService;
import com.jzh.xx.transaction.utils.CookieUtils;
import com.jzh.xx.transaction.utils.SendSmsUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired

    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 登录
     * @param phone
     * @param password
     * @param model
     * @return
     */
    @PostMapping("login")
    public String loginByPassword(String phone, String password, String remember, Model model, HttpSession session, HttpServletResponse response){
        XxUser user = userService.login(phone,password);

        if (user != null){
            session.setAttribute("user",user);
            if (remember != null){
                Cookie cookie = new Cookie("user",user.getPhone()+"_"+user.getPassword());
                cookie.setMaxAge(60*60*24);
                cookie.setPath("login");
                response.addCookie(cookie);
                return "redirect:/index";
            }
            return "redirect:/index";
        }
        else {
            model.addAttribute("message","用户名或密码错误");
            return "login";
        }
    }

    @PostMapping("remember")
    @ResponseBody
    public String remember(HttpSession session,HttpServletRequest request){
        Object user = session.getAttribute("user");
        String value = CookieUtils.getCookieValByKey("user",request);
        if (user != null && !value.equals("") && value != null){
            return value;
        }else {
            return "";
        }
    }


    @GetMapping("register")
    public String toregister(){
        return "register";
    }

    /**
     * 注册
     * @param realname
     * @param phone
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @PostMapping("register")
    public String register(String realname, String phone, String username, String password, String repassword){
        if(!password.equals(repassword)){
            return "redirect:/register";
        }
        userService.register(realname, phone, username, password);
        return "login";
    }

    /**
     * 验证用户名是否存在
     * @param phone
     * @return
     */
    @GetMapping("verPhone/{phone}")
    @ResponseBody
    public Boolean verPhone(@PathVariable String phone) {
        boolean flag = userService.verPhone(phone);
        return flag;
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index";
    }

    /**
     * @Function: 短信验证接口
     */
    @GetMapping("sendCode/{phone}")
    @ResponseBody
    public  String SmsVerification(@PathVariable String phone) {
        String code = SendSmsUtil.sendSms(phone);
//        //将验证码放入Redis
//        String key = "user_"+code;
//        ValueOperations<String,String> operations = redisTemplate.opsForValue();
//
//        operations.set(key,code);
        return code;
    }
}

