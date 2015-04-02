package com.demo.service.impl;


import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:46
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Logger log = LogManager.getLogger(UserService.class);

    @Resource(name = "userDao")
    private UserDao userDao;


    public User findUser(String email, String password) {
        User user = new User();
        try {
            user = userDao.findUser(email,password);
        } catch (Exception e) {
            log.error("查找用户失败：",e);
        }
        return user;
    }
}
