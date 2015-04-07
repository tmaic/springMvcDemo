package com.demo.service;


import com.demo.domain.User;

import java.util.List;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:45
 */
public interface UserService {


    User findUser(String email, String password);

    /**
     * 分页获取所有用户
     * @param pageIndex 当前页
     * @param pageSize 每页数量
     * @return
     */
    List<User> getAllUser(int pageIndex,int pageSize);
}
