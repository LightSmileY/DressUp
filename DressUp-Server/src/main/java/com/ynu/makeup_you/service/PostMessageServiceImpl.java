package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.repository.PostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@Service
public class PostMessageServiceImpl implements PostMessageService{

    @Autowired
    private PostMessageRepository postMessageRepository;
    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private ImageService imageService;

    /**
     * 发帖
     */
    @Override
    public void addPost(PostMessage postMessage) {
        postMessageRepository.save(postMessage);
    }

    @Override
    public void deletePostByUID(String userID) {
        List<PostMessage> postList = postMessageRepository.findByUid(userID);
        for (PostMessage p:postList){
            this.deletePost(p.getPid());
        }
    }

    /**
     * 删除帖
     */
    @Override
    public void deletePost(String postID) {
        favoritesService.deleteByPID(postID);
        likesService.deleteByPID(postID);
        commentsService.deleteByPID(postID);
        imageService.deleteImgByPID(postID);
        postMessageRepository.deleteById(postID);
    }

    /**
     * 更新帖子
     */
    @Override
    public void updatePost(PostMessage postMessage) {
        postMessageRepository.save(postMessage);
    }

    @Override
    public PostMessage findPostsByID(String postID) {
        return postMessageRepository.findById(postID).orElse(null);
    }

    /**
     * 根据用户id查询
     * @param uid
     * @return
     */
    @Override
    public List<PostMessage> findPostsByUid(String uid) {
        return postMessageRepository.findByUid(uid);
    }

    @Override
    public List<PostMessage> findPostsByType(Integer type) {
        return postMessageRepository.findByType(type);
    }

    @Override
    public List<PostMessage> findAllPosts() {
        return postMessageRepository.findAll();
    }
}
