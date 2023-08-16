package com.sample.blogapp.respositories;

import com.sample.blogapp.entities.Article;
import com.sample.blogapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRespository extends JpaRepository<Comment, Long> {
}
