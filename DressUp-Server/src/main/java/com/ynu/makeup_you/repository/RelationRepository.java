package com.ynu.makeup_you.repository;

import com.ynu.makeup_you.entity.CommDoubleKey2;
import com.ynu.makeup_you.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/5/27 0027
 * BY hujianlong
 */
public interface RelationRepository extends JpaRepository<Relation, CommDoubleKey2> {
    /**
     * 找到对应用户的所有关注的数据行
     * @param fansID
     * @return
     */
    List<Relation> findByFans(String fansID);

    /**
     * 找到对应用户的所有粉丝的数据行
     * @param fansID
     * @return
     */
    List<Relation> findByFollows(String fansID);

    void deleteByFans(String fansID);
    void deleteByFollows(String followsID);

}
