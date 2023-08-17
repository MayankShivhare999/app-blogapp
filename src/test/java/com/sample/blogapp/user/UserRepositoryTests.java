package com.sample.blogapp.user;

import com.sample.blogapp.entities.User;
import com.sample.blogapp.respositories.UserRespository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTests {

    @Autowired
    private UserRespository userRespository;

    @Test
    @Order(1)
    void create_users_test() {
        User user = User.builder()
                .username("Chris Duano")
                .email("chris@mail.com")
                .build();
        userRespository.save(user);
    }

    @Test
    @Order(2)
    void find_users() {
        User user = User.builder()
                .username("Chris Duano")
                .email("chris@mail.com")
                .build();
        userRespository.save(user);
        List<User> userList = userRespository.findAll();
        Assertions.assertThat(userList.size()).isEqualTo(1);
    }
}
