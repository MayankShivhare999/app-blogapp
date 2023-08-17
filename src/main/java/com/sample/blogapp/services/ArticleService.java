package com.sample.blogapp.services;

import com.sample.blogapp.entities.Article;
import com.sample.blogapp.request.CreateArticleRequest;

import java.util.List;

public interface ArticleService {

    Article createArticle(CreateArticleRequest a, Long authorId);

    List<Article> getAllArticles();

    Article getArticleBySlug(String slug);

    Article updateArticle(Long articleId, CreateArticleRequest a);
}
