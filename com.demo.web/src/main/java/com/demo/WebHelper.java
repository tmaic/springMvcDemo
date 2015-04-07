package com.demo;


import com.demo.domain.util.CookieDomain;

/**
 * User: meichao
 * Date: 14-7-8
 * Time: 上午10:40
 */
public class WebHelper {
    private static final String Auth_Domain_key = "Auth_Domain_key";

    public static final String getPin() {
        String pin = null;

        CookieDomain cookieDomain = null;
        try {
            cookieDomain = (CookieDomain) SpringMvcContextHolder.getSessionAttribute(Auth_Domain_key);
            pin = cookieDomain.getEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pin;
    }


    public static final void setAuthDomain(Object obj) {
        SpringMvcContextHolder.setSessionAttribute(Auth_Domain_key, obj);
    }
}
