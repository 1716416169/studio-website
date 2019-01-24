package cn.cks.studiowebsite.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器一号启动");
        System.out.println("管理员身份验证成功："+request.getParameter("admin"));
        if(request.getParameter("admin").equals("root")){
            return true;
        }else{
            System.out.println("你是谁");
            response.sendRedirect("/gm");
            return false;
        }

    }
}
