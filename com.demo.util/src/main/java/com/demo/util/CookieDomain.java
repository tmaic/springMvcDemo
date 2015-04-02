package com.demo.util;

/**
 * User: meichao
 * Date: 14-7-4
 * Time: 上午10:01
 */
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


    //get set


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }
}
