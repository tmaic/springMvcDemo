package com.demo.dao.impl;


import com.demo.dao.UserDao;
import com.demo.dao.base.BaseDao;
import com.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:48
 */
@Component("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {


    public User findUser(String email, String password) {
        Map map = new HashMap();
        map.put("email",email);
        map.put("password",password);
        return this.writerSqlSession.selectOne("com.demo.dao.UserDao.findUser", map);
    }

    public int getUserCount() {
        return this.writerSqlSession.selectOne("com.demo.dao.UserDao.getUserCount");
    }


    public List<User> getAllUser(int pageIndex, int pageSize) {
        Map map = new HashMap();
        map.put("start",pageIndex);
        map.put("end",pageSize);
        return this.writerSqlSession.selectList("com.demo.dao.UserDao.getAllUser",map);
    }
}
