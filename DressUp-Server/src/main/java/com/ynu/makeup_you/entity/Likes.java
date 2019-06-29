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
    private String userID;
    private String postID;
    private String time;

    @Id
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Id
    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
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
