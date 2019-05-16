package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Posts;
import com.ynu.makeup_you.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */

@Service
public class PostsServiceImpl implements PostsService{

    @Autowired
    PostsRepository postsRepository;

    @Override
    public List<Posts> getAllPosts(Integer userID) {
        return postsRepository.findByUserID(userID);
    }
}
