package com.sample.blogapp.respositories;

import com.sample.blogapp.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Optional<Article> findBySlug(String slug);
}
