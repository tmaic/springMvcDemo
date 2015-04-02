package com.demo.dao.base;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * User: meichao
 * Date: 14-6-30
 * Time: 下午4:08
 */
public class BaseDao {

    @Resource(name="writerSqlSession")
    public SqlSessionTemplate writerSqlSession;

}
