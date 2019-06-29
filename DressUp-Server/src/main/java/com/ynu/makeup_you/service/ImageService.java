package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Image;

import java.util.List;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */
public interface ImageService {
    void addRecord(Image image);
    List<String> getAllImg(String postID);
    void deleteImgByPID(String postID);
}
