package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.PostMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface PostMessageRepository extends JpaRepository<PostMessage,Integer> {
    public List<PostMessage> findByType(Integer type);
}
