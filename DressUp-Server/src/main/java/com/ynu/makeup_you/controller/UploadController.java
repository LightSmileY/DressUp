package com.ynu.makeup_you.controller;

import com.ynu.makeup_you.repository.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ynu.makeup_you.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created on 2019/6/11
 * BY fukami
 * 上传图片等文件（单个与多个）
 */
@Controller
public class UploadController {
    @Value(value = "${data.filePath}")
    String filePath;

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/multiUpload")
    @ResponseBody
    @Transactional
    public String multiUpload(HttpServletRequest request,
                              @RequestParam("postID") String id) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第" + (i + 1) + "个文件上传成功");
                Image image = new Image();
                image.setPostID(id);
                image.setImgID(dest.getPath());
                imageRepository.save(image);
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }

        return "上传成功";

    }

}