package com.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/3
 * Time: 11:34
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
@Service("baseService")
public class BaseService {

    public int getMySqlStartRow(int startRow) {
        return startRow > 1 ? startRow - 1 : 0;
    }
}
