package com.demo.web;


import com.demo.domain.User;
import com.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 14-1-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */

@Controller/**交由spring管理的bean**/
public class IndexController {

    @Autowired/**自动装配**/
    private IndexService indexService;


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
        user.setName("tmaic");
        user.setPwd("aljglaglagla");
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
