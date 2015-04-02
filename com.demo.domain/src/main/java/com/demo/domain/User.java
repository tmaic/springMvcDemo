package com.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * User: meichao
 * Date: 14-7-1
 * Time: 下午4:36
 */
@Data
public class User {

    private int id;

    private String email;

    private String password;

    private Date created;

    private Date modified;

}
