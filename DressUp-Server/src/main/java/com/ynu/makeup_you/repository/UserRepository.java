package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface UserRepository extends JpaRepository<User,String> {
    /**
     * 自定义了两个查询接口，根据id查用户，根据姓名查用户
     */
    public User findUserByUid(String id);
    public User findUserByName(String name);
}
