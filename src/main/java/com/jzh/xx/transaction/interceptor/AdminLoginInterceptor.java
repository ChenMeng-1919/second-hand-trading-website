package com.jzh.xx.transaction.interceptor;

import com.jzh.xx.transaction.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //获取管理员信息
        Admin admin = (Admin) session.getAttribute("admin");
        //管理员未登录
        if (admin == null){
            response.sendRedirect("admin/login");
            return true;
        }
        //管理员已登录
        else {
            response.sendRedirect("admin/home");
            return false;
        }
    }
}
