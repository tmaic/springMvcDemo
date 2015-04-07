package com.demo.service.impl;


import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.domain.page.PaginatedArrayList;
import com.demo.domain.page.PaginatedList;
import com.demo.service.BaseService;
import com.demo.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:46
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

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

    /**
     * 分页获取所有用户
     *
     * @param pageIndex 当前页
     * @param pageSize  每页数量
     * @return
     */
    public List<User> getAllUser(int pageIndex, int pageSize) {
        PaginatedList<User> userList = new PaginatedArrayList<User>(pageIndex, pageSize);
        userList.setTotalItem(userDao.getUserCount());
        List<User> users = userDao.getAllUser(getMySqlStartRow(pageIndex),pageSize);
        userList.addAll(users);
        return userList;
    }
}
