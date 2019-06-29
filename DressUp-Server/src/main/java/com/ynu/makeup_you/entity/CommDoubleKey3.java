package com.ynu.makeup_you.entity;

import java.io.Serializable;

/**
 * Created on 2019/5/29 0029
 * BY hujianlong
 */
public class CommDoubleKey3 implements Serializable {
    private String postID;
    private String imgID;

    /**
     * Getter and Setter
     * @return
     */
    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getImgID() {
        return imgID;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    /**
     * 重写equals和Hashcode方法
     */

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((postID == null) ? 0 : postID.hashCode());
        result = PRIME * result + ((imgID == null) ? 0 : imgID.hashCode());
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

        final CommDoubleKey3 other = (CommDoubleKey3) obj;
        if(postID == null){
            if(other.postID != null){
                return false;
            }
        }else if(!postID.equals(other.postID)){
            return false;
        }
        if(imgID == null){
            if(other.imgID != null){
                return false;
            }
        }else if(!imgID.equals(other.imgID)){
            return false;
        }

        return true;
    }
}
