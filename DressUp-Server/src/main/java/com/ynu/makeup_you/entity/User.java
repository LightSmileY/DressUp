package com.ynu.makeup_you.entity;

import javax.persistence.*;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */

@Entity
@Table(name="user")
public class User {
    /**
     * Id
     */
    @Id
    private String uid;

    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="mailbox")
    private String mailbox;
    @Column(name="sex")
    private Integer sex;
    @Column(name="age")
    private Integer age;
    @Column(name="birthday")
    private String birthday;
    @Column(name="register_date")
    private String register_date;
    @Column(name="avatarID")
    private String avatarID;
    @Column(name="description")
    private String description;
    @Column(name="last_login_time")
    private String last_login_time;

    /**
     * 构造函数
     */
    public User(){

    }

    public User(String uid, String name, String password, String birthday, Integer sex, Integer age,
                String register_date, String avatarID, String description, String mailbox, String last_login_time){
        this.uid = uid;
        this.name = name;
        this.password = password;
        if(birthday.equals(""))
            birthday=null;
        this.birthday = birthday;
        this.sex = sex;
        this.age = age;
        this.register_date = register_date;
        this.avatarID = avatarID;
        this.description = description;
        this.mailbox = mailbox;
        if(last_login_time.equals(""))
            last_login_time=null;
        this.last_login_time = last_login_time;
    }

    /**
     * Getter and Setter
     */

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if(birthday.equals(""))
            birthday=null;
        this.birthday = birthday;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(String avatarID) {
        this.avatarID = avatarID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        if(last_login_time.equals(""))
            last_login_time=null;
        this.last_login_time = last_login_time;
    }

}
