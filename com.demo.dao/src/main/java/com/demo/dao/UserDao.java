package com.demo.dao;


import com.demo.domain.User;

import java.util.List;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:48
 */
public interface UserDao {
    User findUser(String email, String password);

    int getUserCount();

    List<User> getAllUser(int pageIndex, int pageSize);
}
