package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.User;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface UserService {

    /**
     * 增加用户、删除用户、更新用户、查询全部用户、根据姓名查询用户、根据ID查询用户接口
     */
    void addUser(User user);
    void deleteUser(String id);
    void updateUser(User user);
    List<User> findAllUser();
    User getUserByID(String id);
    User getUserByName(String name);
}
