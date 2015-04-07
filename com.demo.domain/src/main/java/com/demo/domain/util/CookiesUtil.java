package com.demo.domain.util;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/4/3
 * Time: 15:38
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
public class CookiesUtil {
    public final static Logger log = Logger.getLogger(CookiesUtil.class);

    /**
     * 加密key
     */
    public final static String COOKIE_KEY = "key_configCenter";

    public final static String COOKIE_NAME = "config_center";

    /**
     * cookie的过期时间
     * 单位：秒
     */
    public final static int expiry = 60*60;





    public static Cookie newCookie(String value) {
        Cookie cookie = null;
        try {
            DesEncrypt crypt = new DesEncrypt(COOKIE_KEY);
            String newValue = crypt.encrypt(value);
            cookie = new Cookie(COOKIE_NAME, newValue);
            cookie.setPath("/");
            if (expiry > 0) {
                cookie.setMaxAge(expiry);
            }
        } catch (Exception e) {
            log.error("加密失敗",e);
        }
        return cookie;
    }

    /**
     * 设置cookie值，必须定义后才能设置。
     *
     * @param servletResponse
     * @param email 用户名
     */
    public static CookieDomain setCookie(HttpServletResponse servletResponse, String email) {

        CookieDomain cd = new CookieDomain();
        cd.setEmail(email);
        cd.setDomain("config.center.com");
        cd.setName(CookiesUtil.COOKIE_NAME);
        cd.setExpiry(CookiesUtil.expiry);
//        String cookieJson = JSON.toJSONString(cd);
        String cookieJson = cd.getEmail() + ":" + cd.getCreated() + ":" +cd.getExpiry();
        Cookie cookie = newCookie(cookieJson);
        servletResponse.addCookie(cookie);
        return cd;
    }


    /**
     * 从cookie中取值值，会自动解密(如果是加密保存)。
     *
     * @param servletRequest
     * @return
     */
    public static String getCookieValue(HttpServletRequest servletRequest) {
        Cookie[] cookies = servletRequest.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals(COOKIE_NAME)) {
                    return getValue(cookie.getValue());
                }
            }
        }
        return null;
    }

    public static String getValue(String value) {
        DesEncrypt crypt = new DesEncrypt(COOKIE_KEY);
        String v = null;
        try {
            v =  crypt.decrypt(value);
        } catch (Exception e) {
            log.error("解密失敗",e);
        }
        return v;
    }


    /**
     * 删除cookie，不管有没有定义都能删除
     *
     * @param servletResponse
     */
    public static void deleteCookie(HttpServletResponse servletResponse) {
        Cookie cookie;
        cookie = new Cookie(CookiesUtil.COOKIE_NAME, null);
        cookie.setMaxAge(0);
        servletResponse.addCookie(cookie);
    }

}
