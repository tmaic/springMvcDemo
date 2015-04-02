package com.demo.interceptor;

import com.demo.util.CookiesUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/2
 * Time: 16:00
 * Desc: 用于过滤未登陆用户访问管理内容的拦截器
 * To change this template use File | Settings | File Templates.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger log = LogManager.getLogger(LoginInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String value = CookiesUtil.getCookieValue(request);
        //1.是否存在对应cookie
        if(StringUtils.isNotBlank(value)){

            //2.cookie是否过期
            String[] str = value.split(":");
            String email = str[0];
            long created = Long.parseLong(str[1]);
            int expiry = Integer.parseInt(str[2]);

            long nowTime = System.currentTimeMillis();

            if (nowTime - created < expiry*1000){
                //未过期重新赋值
                CookiesUtil.setCookie(response,email);
                return true;
            }else {
                response.sendRedirect(request.getContextPath()+"/login.html");
                return false;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
