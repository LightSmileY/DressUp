package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Posts;

import java.util.List;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */
public interface PostsService {
    /**
     * 查询特定的用户发表过的所有帖子
     */
    public List<Posts> getAllPosts(Integer userID);
}
