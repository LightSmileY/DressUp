package com.ynu.makeup_you.service;

import com.ynu.makeup_you.entity.Favorites;
import com.ynu.makeup_you.entity.User;
import com.ynu.makeup_you.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/5/15
 * BY hujianlong
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private PostMessageService postMessageService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private RelationService relationService;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        favoritesService.deleteByUID(id);
        likesService.deleteByUID(id);
        commentsService.deleteByUID(id);
        postMessageService.deletePostByUID(id);
        relationService.deleteByFans(id);
        relationService.deleteByFollows(id);
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(String id) {
        return userRepository.findUserByUid(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
