package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.User;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface UserService {

    /**
     * 增加用户、删除用户、更新用户、查询用户接口
     */
    public void addUser(User user);
    public void deleteUser(Integer id);
    public void updateUser(User user);
    public User findUser(Integer id);
    public List<User> findAllUser();

}
