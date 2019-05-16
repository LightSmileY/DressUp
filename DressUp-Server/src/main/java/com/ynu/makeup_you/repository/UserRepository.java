package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
