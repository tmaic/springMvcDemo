package com.demo.web;

import com.google.common.base.Strings;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/2
 * Time: 16:00
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping(value = "/admin")
@Controller
public class DashBoardController {


    private final static Logger log = LogManager.getLogger(DashBoardController.class);

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
