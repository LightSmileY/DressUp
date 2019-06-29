package com.ynu.makeup_you.entity;

import java.io.Serializable;

/**
 * Created on 2019/5/16 0016
 * BY hujianlong
 */
public class CommDoubleKey implements Serializable {
    private String userID;
    private String postID;

    /**
     * Getter 和 Setter
     */
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    /**
     * 重写equals和Hashcode方法
     */

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((userID == null) ? 0 : userID.hashCode());
        result = PRIME * result + ((postID == null) ? 0 : postID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final CommDoubleKey other = (CommDoubleKey) obj;
        if(userID == null){
            if(other.userID != null){
                return false;
            }
        }else if(!userID.equals(other.userID)){
            return false;
        }
        if(postID == null){
            if(other.postID != null){
                return false;
            }
        }else if(!postID.equals(other.postID)){
            return false;
        }

        return true;
    }

}
