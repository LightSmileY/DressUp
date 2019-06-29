package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Comments;
import com.ynu.makeup_you.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
@Service
public class CommentsServiceImpl implements  CommentsService{

    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public void addRecord(Comments comments) {
        commentsRepository.save(comments);
    }

    @Override
    public void deleteByUID(String userID) {
        commentsRepository.deleteByUserID(userID);
    }

    @Override
    public void deleteByPID(String postID) {
        commentsRepository.deleteByPostID(postID);
    }

    @Override
    public void deleteRecord(String userID, String postID) {
        CommDoubleKey commentsKey = new CommDoubleKey();
        commentsKey.setUserID(userID);
        commentsKey.setPostID(postID);
        commentsRepository.deleteById(commentsKey);
    }

    @Override
    public List<Comments> getAllcommentsOfUser(String userID) {
        return commentsRepository.findByUserID(userID);
    }

    @Override
    public List<Comments> getAllCommentsOfPostmsg(String postID) {
        return commentsRepository.findByPostID(postID);
    }
}
