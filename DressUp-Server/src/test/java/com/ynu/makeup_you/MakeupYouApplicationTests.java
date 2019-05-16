package com.ynu.makeup_you;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.repository.FavoritesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MakeupYouApplicationTests {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Test
    public void saveFavoritesTest() throws Exception{
        CommDoubleKey favoritesKey = new CommDoubleKey();
        favoritesKey.setUserID(123);
        favoritesKey.setPostID(456);
        Favorites favorites = entityManager.find(Favorites.class, favoritesKey);
        System.out.println(favorites);
    }

}
