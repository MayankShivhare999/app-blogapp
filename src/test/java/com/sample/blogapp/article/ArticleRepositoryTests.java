package com.sample.blogapp.article;

import com.sample.blogapp.entities.Article;
import com.sample.blogapp.entities.User;
import com.sample.blogapp.respositories.ArticleRepository;
import com.sample.blogapp.respositories.UserRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ArticleRepositoryTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRespository userRespository;

    @Test
    void create_article_with_existing_user_test() {

        User user = User.builder()
                .username("Chris Duano")
                .email("chris@mail.com")
                .build();
        userRespository.save(user);

        Article article = Article.builder()
                .title("sample title")
                .slug("sample slug")
                .body("sample body")
                .author(user)
                .build();

        articleRepository.save(article);
    }

    @Test
    void create_aritcle_without_user_test() {
        Article article = Article.builder()
                .title("sample title")
                .slug("sample slug")
                .body("sample body")
                .build();

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> articleRepository.save(article));
    }

}
