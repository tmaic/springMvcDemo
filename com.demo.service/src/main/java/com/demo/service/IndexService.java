package com.demo.service;

import com.demo.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: meichao
 * Date: 14-1-10
 * Time: 下午2:50
 */

@Service  /**交由spring管理的bean**/
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    public String sayHiMVC(){
        indexDao.queryDBbyStat();
        System.out.println("Hi Spring MVC");
        return "Hi Spring MVC";
    }

}
