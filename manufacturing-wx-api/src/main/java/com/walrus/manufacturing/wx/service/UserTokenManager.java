package com.walrus.manufacturing.wx.service;

import com.walrus.manufacturing.wx.util.JwtHelper;

/**
 * 维护用户token
 */
public class UserTokenManager {
    public static String generateToken(Integer id) {
        JwtHelper jwtHelper = new JwtHelper();
        return jwtHelper.createToken(id);
    }

    public static Integer getUserId(String token) {
        JwtHelper jwtHelper = new JwtHelper();
        Integer userId = jwtHelper.verifyTokenAndGetUserId(token);
        if (userId == null || userId == 0) {
            return null;
        }
        return userId;
    }

    public static String getAppId(String token) {
        JwtHelper jwtHelper = new JwtHelper();
        String appId = jwtHelper.verifyTokenAndGetAppId(token);
        if (appId == null || appId.equals("")) {
            return appId;
        }
        return appId;
    }
}
