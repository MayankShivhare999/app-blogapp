package com.sample.blogapp.user;

import com.sample.blogapp.entities.User;
import com.sample.blogapp.request.CreateUserRequest;
import com.sample.blogapp.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void create_users() {
        User user = userService.createUser(new CreateUserRequest(
                "armand",
                "password1",
                "armand@mail.com"
        ));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("armand", user.getUsername());
    }
}
