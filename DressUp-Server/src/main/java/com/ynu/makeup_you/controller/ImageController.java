package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    /**
     * 获得发帖的所有图片
     * @param postID
     * @return
     */
    @GetMapping("/getAllImg")
    public List<String> getAllImg(@RequestParam("postID") String postID){
        return imageService.getAllImg(postID);
    }
}
