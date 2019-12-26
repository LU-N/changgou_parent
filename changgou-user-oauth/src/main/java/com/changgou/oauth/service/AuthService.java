package com.changgou.oauth.service;

import com.changgou.oauth.util.AuthToken;

/**
 * @author JinLu
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
