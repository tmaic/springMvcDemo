package com.demo.web;


import com.demo.WebHelper;
import com.demo.domain.User;
import com.demo.service.IndexService;
import com.demo.service.UserService;
import com.demo.util.CookieDomain;
import com.demo.util.CookiesUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 14-1-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */

@Controller/**交由spring管理的bean**/
public class IndexController {


    private final static Logger log = LogManager.getLogger(IndexController.class);

    @Autowired/**自动装配**/
    private IndexService indexService;

    @Autowired/**自动装配**/
    private UserService userService;

    private SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }


    @RequestMapping(value="/doLogin",method= RequestMethod.POST)
    public ModelAndView doLogin(String email,String password,HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv=new ModelAndView("");
        User user = userService.findUser(email,password);
        if(user != null && StringUtils.isNotBlank(user.getEmail())){
            CookieDomain cd = CookiesUtil.setCookie(response, user.getEmail());
            WebHelper.setAuthDomain(cd);
            mv.setViewName("redirect:/admin/dashboard.html");
            log.info("用户[" + user.getEmail() + "]在[" + formater.format(new Date()) + "]时间登陆");
        }else{
            mv.setViewName("forward:/login");
            mv.addObject("email",email);
            mv.addObject("message", "email or password error ");
        }
        return mv;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse response){
        CookiesUtil.deleteCookie(response);
        return "login";
    }


    /**访问URL：http://localhost/turn.html**/
    @RequestMapping(value = "/turn",method = RequestMethod.GET)
    public String turn(){
        return "turn";
    }


    /**访问URL：http://localhost/home.html**/
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView index(){
        indexService.sayHiMVC();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name","tmaic");  //---->等同于new ModelAndView("index","name","tmaic")
        return mav;
    }

    /**返回json**/
    /**访问URL：http://localhost/show.html**/
    @RequestMapping(value = "/show")
    public @ResponseBody User showMessage(){
        User user = new User();
        user.setId(2);
        user.setEmail("tmaic");
        user.setPassword("aljglaglagla");
        return user;
    }

    /**传参**/
    /**访问URL：http://localhost/say/1.html**/
    @RequestMapping(value = "/say/{id}")
    public ModelAndView sayHi(@PathVariable String id){
        System.out.println("id = " + id);
        ModelAndView mav = new ModelAndView("say");
        mav.addObject("name",id);
        return mav;
    }

}
