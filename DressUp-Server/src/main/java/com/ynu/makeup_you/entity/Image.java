package com.ynu.makeup_you.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */

@Entity
@Table(name="image")
@IdClass(CommDoubleKey3.class)
public class Image {
    private String postID;
    private String imgID;

    public Image(){

    }

    public Image(String postID, String imageID){
        this.postID = postID;
        this.imgID = imageID;
    }

    @Id
    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Id
    public String getImgID() {
        return imgID;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        return "image{postID=" + this.getPostID() + ", imgID=" + this.getImgID() + "}";
    }
}