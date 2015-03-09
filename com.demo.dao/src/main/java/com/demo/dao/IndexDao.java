package com.demo.dao;

import org.springframework.stereotype.Repository;

/**
 * User: meichao
 * Date: 14-4-22
 * Time: 下午1:35
 */
@Repository
public class IndexDao {
    public String queryDBbyStat(){
        System.out.println("query someting");
        return "query someting";
    }
}
