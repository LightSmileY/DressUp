package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
public interface PostsRepository extends JpaRepository<Posts, CommDoubleKey> {
    public List<Posts> findByUserID(Integer uid);
}
