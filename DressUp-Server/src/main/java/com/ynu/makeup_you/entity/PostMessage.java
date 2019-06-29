package com.ynu.makeup_you.entity;

import javax.persistence.*;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="postmessage")
public class PostMessage {
    @Id
    private String pid;
    @Column(name = "uid")
    private String uid;
    @Column(name="post_time")
    private String postTime;
    @Column(name="type")
    private Integer type;
    @Column(name="title")
    private String title;
    @Column(name="messagebody")
    private String messagebody;

    /**
     * 构造函数
     */
    public PostMessage(){

    }

    public PostMessage(String pid, String uid, String postTime, Integer type, String title, String messagebody){
        this.pid = pid;
        this.uid = uid;
        this.postTime = postTime;
        this.type = type;
        this.title = title;
        this.messagebody = messagebody;
    }

    /**
     * Getter and Setter
     */
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessagebody() {
        return messagebody;
    }

    public void setMessagebody(String messagebody) {
        this.messagebody = messagebody;
    }
}
