package com.sample.blogapp.services.impl;

import com.sample.blogapp.entities.Article;
import com.sample.blogapp.entities.User;
import com.sample.blogapp.exceptions.ArticleNotFoundException;
import com.sample.blogapp.exceptions.UserNotFoundException;
import com.sample.blogapp.respositories.ArticleRepository;
import com.sample.blogapp.respositories.UserRespository;
import com.sample.blogapp.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.blogapp.request.CreateArticleRequest;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    private final UserRespository userRespository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, UserRespository userRespository) {
        this.articleRepository = articleRepository;
        this.userRespository = userRespository;
    }

    @Override
    public Article createArticle(CreateArticleRequest a, Long authorId) {
        User user = userRespository.findById(authorId).orElseThrow(() -> new UserNotFoundException("User with userId: "+authorId+" not found!!!"));
        Article article = Article
                .builder()
                .title(a.getTitle())
                .slug(a.getTitle().toLowerCase().replaceAll("\\s+", "-").trim())
                .body(a.getBody())
                .subtitle(a.getSubtitle())
                .build();
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleBySlug(String slug) {
        return articleRepository.findBySlug(slug).orElseThrow(() -> new ArticleNotFoundException("Article with slug :"+slug+" not found!!!"));
    }

    @Override
    public Article updateArticle(Long articleId, CreateArticleRequest a) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException("Article with id: "+articleId+" not found"));
        if(a.getTitle() != null) {
            article.setTitle(a.getTitle());
            article.setSlug(a.getTitle().toLowerCase().replaceAll("\\s+", "-"));
        }
        if(a.getBody() != null) {
            article.setBody(a.getBody());
        }
        if(a.getSubtitle() != null) {
            article.setSubtitle(a.getSubtitle());
        }
        return articleRepository.save(article);
    }


}
