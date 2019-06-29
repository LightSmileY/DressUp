package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
public interface CommentsRepository extends JpaRepository<Comments, CommDoubleKey> {
    void deleteByUserID(String userID);
    void deleteByPostID(String postID);
    List<Comments> findByUserID(String uid);
    List<Comments> findByPostID(String postid);
}
