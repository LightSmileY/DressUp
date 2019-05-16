package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.entity.FavoritesKey;
import com.ynu.makeup_you.entity.PostMessage;
import com.ynu.makeup_you.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
public interface FavoritesRepository extends JpaRepository<Favorites, FavoritesKey> {
    public List<Favorites> findByUserID(Integer uid);
    public List<Favorites> findByPostID(Integer postid);
}
