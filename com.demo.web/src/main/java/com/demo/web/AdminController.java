package com.demo.web;

import com.google.common.base.Strings;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by meichao on 2015/3/19.
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController {


    private final static Logger log = LogManager.getLogger(AdminController.class);

    @RequestMapping(value = "/dashboard")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }

    public static void main(String[] args) {
        String a = "sdfdsfsdfsd";
        String b = "sddfdfdfdf";
        System.out.println("b = " + Strings.commonPrefix(a, b));
        System.out.println("b = " + Strings.repeat(b,3));
    }
}
