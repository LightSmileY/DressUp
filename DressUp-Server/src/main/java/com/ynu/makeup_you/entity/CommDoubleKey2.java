package com.ynu.makeup_you.entity;

import java.io.Serializable;

/**
 * Created on 2019/5/27 0027
 * BY hujianlong
 */
public class CommDoubleKey2 implements Serializable {
    private String fans;
    private String follows;

    /**
     * Getter和Setter
     * @return
     */
    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFollows() {
        return follows;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    /**
     * 重写equals和Hashcode方法
     */

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((fans == null) ? 0 : fans.hashCode());
        result = PRIME * result + ((follows == null) ? 0 : follows.hashCode());
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

        final CommDoubleKey2 other = (CommDoubleKey2) obj;
        if(fans == null){
            if(other.fans != null){
                return false;
            }
        }else if(!fans.equals(other.fans)){
            return false;
        }
        if(follows == null){
            if(other.follows != null){
                return false;
            }
        }else if(!follows.equals(other.follows)){
            return false;
        }

        return true;
    }
}
