package com.demo.service;


import com.demo.domain.User;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:45
 */
public interface UserService {


    User findUser(String email, String password);
}
