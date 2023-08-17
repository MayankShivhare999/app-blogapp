package com.sample.blogapp.respositories;

import com.sample.blogapp.entities.Comment;
import com.sample.blogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
