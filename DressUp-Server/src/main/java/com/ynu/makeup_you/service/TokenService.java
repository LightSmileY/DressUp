package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.AdminUser;
import com.ynu.makeup_you.entity.User;

/**
 * Created on 2019/6/8 0008
 * BY hujianlong
 */
public interface TokenService {
    String getToken(User user);
    String getToken(AdminUser au);
}
