package com.demo.domain.util;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/3
 * Time: 15:37
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
@Data
public class CookieDomain {

    /**
     * cookie 名字
     */
    private String name;

    private String domain;

    private String email;

    /**
     * 创建时间
     * 默认为当前时间
     */
    private long created = System.currentTimeMillis();

    /**
     * cookie的过期时间
     * 单位：秒
     */
    private int expiry;
}
