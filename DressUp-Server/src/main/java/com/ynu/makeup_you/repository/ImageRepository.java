package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.CommDoubleKey3;
import com.ynu.makeup_you.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */
public interface ImageRepository extends JpaRepository<Image, CommDoubleKey3> {
    /**
     * 找到对应帖子的全部图片列表
     * @param postID
     * @return
     */
    List<Image> findByPostID(String postID);
    void deleteByPostID(String postID);
}
