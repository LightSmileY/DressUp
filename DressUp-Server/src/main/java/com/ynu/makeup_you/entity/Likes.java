package com.ynu.makeup_you.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created on 2019/5/16
 * BY hujianlong
 */

@Entity
@Table(name="likes")
@IdClass(CommDoubleKey.class)
public class Likes {
    private Integer userID;
    private Integer postID;
    private String time;

    @Id
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Id
    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 重写toString方法
     */

    @Override
    public String toString() {
        return "likes{" +
                "userID=" + userID +
                ", postID=" + postID +
                ", time='" + time + '\'' +
                '}';
    }

}
