package com.ynu.makeup_you;

import com.ynu.makeup_you.entity.CommDoubleKey;
import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.repository.FavoritesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value(value = "${data.filePath}")
    public String filePath;

    @Test
    public void configTest() throws Exception{
        System.out.println(filePath);
    }

}
