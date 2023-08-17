package com.sample.blogapp.services;

import com.sample.blogapp.entities.User;
import com.sample.blogapp.request.CreateUserRequest;

public interface UserService {

    public User createUser(CreateUserRequest u);

    public User getUser(String username);

    public User getUser(Long id);

    public User loginUser(String username, String password);

}
