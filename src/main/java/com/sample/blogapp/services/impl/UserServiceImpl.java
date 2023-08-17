package com.sample.blogapp.services.impl;

import com.sample.blogapp.entities.User;
import com.sample.blogapp.exceptions.UserNotFoundException;
import com.sample.blogapp.respositories.UserRespository;
import com.sample.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.blogapp.request.CreateUserRequest;

@Service
public class UserServiceImpl implements UserService {

    private final UserRespository userRespository;

    @Autowired
    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User createUser(CreateUserRequest u) {
        User user = User
                .builder()
                .email(u.getEmail())
                .username(u.getUsername())
                .build();
        return userRespository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRespository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username: "+username+" not found!!"));
    }

    @Override
    public User getUser(Long id) {
        return userRespository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: "+id+" not found!!"));
    }

    @Override
    public User loginUser(String username, String password) {
        //TODO: logic for login

        return null;
    }
}
