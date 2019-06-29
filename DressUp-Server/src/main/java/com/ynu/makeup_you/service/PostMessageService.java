package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.PostMessage;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
public interface PostMessageService {
    /**
     * 发帖、删除帖子、编辑帖子、根据用户id查询帖子，根据类型查询帖子，查询全部的帖子
     */
    void addPost(PostMessage postMessage);
    void deletePostByUID(String userID);
    void deletePost(String postid);
    void updatePost(PostMessage postMessage);
    PostMessage findPostsByID(String postID);
    List<PostMessage> findPostsByUid(String uid);
    List<PostMessage> findPostsByType(Integer type);
    List<PostMessage> findAllPosts();
}
