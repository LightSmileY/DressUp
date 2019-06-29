package com.ynu.makeup_you.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created on 2019/5/27 0027
 * BY hujianlong
 */

@Entity
@Table(name="relation")
@IdClass(CommDoubleKey2.class)
public class Relation {
    private String fans;
    private String follows;

    public Relation(){

    }

    public Relation(String fans, String follows){
        this.fans = fans;
        this.follows = follows;
    }

    @Id
    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    @Id
    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        return "relation{fansID=" + this.getFans() + ", followsID=" + this.getFollows() + "}";
    }
}
