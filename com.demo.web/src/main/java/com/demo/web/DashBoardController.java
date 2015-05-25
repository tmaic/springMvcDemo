package com.demo.web;

import com.demo.domain.User;
import com.demo.domain.page.TableData;
import com.demo.service.UserService;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

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


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dashboard")
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("dashboard");
        return mav;
    }


    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public ModelAndView userList(){
        List<User> users = userService.getAllUser(0,20);

        ModelAndView mav = new ModelAndView("user/userList");
        mav.addObject("users",users);
        return mav;
    }


    @RequestMapping(value = "/userJson",method = RequestMethod.GET)
    @ResponseBody
    public TableData userJson(int iDisplayLength,
                              int iDisplayStart,
                              int sEcho){
        List<User> userList = userService.getAllUser(iDisplayStart,iDisplayLength);
        TableData tableData = new TableData();
        tableData.setResults(userList);
        tableData.setSEcho(sEcho+1);
        tableData.setTotalDisplayRecords(userList.size());
        tableData.setTotalRecords(userList.size());

        return tableData;
    }

    public static void main(String[] args) {
        String a = "sdfdsfsdfsd";
        String b = "sddfdfdfdf";
        System.out.println("b = " + Strings.commonPrefix(a, b));
        System.out.println("b = " + Strings.repeat(b,3));



//        CollectionUtils.filter();


    }
}
