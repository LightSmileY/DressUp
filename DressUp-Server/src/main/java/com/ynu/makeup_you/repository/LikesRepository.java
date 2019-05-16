package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

public interface LikesRepository extends JpaRepository<Likes, CommDoubleKey> {
    public List<Likes> findByUserID(Integer uid);
    public List<Likes> findByPostID(Integer postid);
}
